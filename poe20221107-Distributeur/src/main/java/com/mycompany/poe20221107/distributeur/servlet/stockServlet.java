package com.mycompany.poe20221107.distributeur.servlet;

import com.mycompany.poe20221107.distributeur.model.Basket;
import com.mycompany.poe20221107.distributeur.model.Product;
import com.mycompany.poe20221107.distributeur.model.Stock;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/distributeur")
public class stockServlet extends HttpServlet {

    Stock stock = new Stock();
    

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String showbasket = request.getParameter("showbasket");
        request.getSession().setAttribute("stock",stock);
        if (showbasket != null && showbasket.equals("true")) {

            Basket basket = (Basket) request.getSession().getAttribute("basket");
            if (basket == null) {
                basket = new Basket();
            }

            // affichage JSP
            request.setAttribute("productsBasket", basket.getBasket());
            request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);
        } else {
            // affichage JSP
            request.setAttribute("stock", stock.getStock());
            request.getRequestDispatcher("WEB-INF/distributeur.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            String idString = request.getParameter("productId");
            int id = Integer.parseInt(idString);
            
            //find product in the stock
            Product product = stock.findProduct(id);

            //recuperation  of basket from session
            Basket basket = (Basket) request.getSession().getAttribute("basket");
            if (basket == null) {
                basket = new Basket();
            }
            //calculate remain credit before adding
            
            double totalprice = basket.calculateTotalPrice();
            double money = (double) request.getSession().getAttribute("moneyDouble");
            double remainCredit1 = money - totalprice;
            request.setAttribute("remainBefore",remainCredit1);

            if (product.getQuantity() > 0) {
                if (remainCredit1 > product.getPrice()) {
                    //reduce quantity of product in stock:
                    product.setQuantity(product.getQuantity() - 1);
                    //check if product is already in the basket and put in the basket
                    Product productCheck = basket.findProduct(id);

                    if (productCheck == null) {
                        Product newProduct = new Product();
                        newProduct.setName(product.getName());
                        newProduct.setId(product.getId());
                        newProduct.setPrice(product.getPrice());
                        newProduct.setQuantity(1);
                        basket.addProduct(newProduct);

                    } else {
                        productCheck.setQuantity(productCheck.getQuantity() + 1);
                    }
                } else {
                    request.getSession().setAttribute("Error", "you need more money");
                }
            } else {
                request.getSession().setAttribute("Error", product.getName() + " sold out");
            }

            // calculate total price of all products in the backet
            double totalPrice1 = basket.calculateTotalPrice();
            request.getSession().setAttribute("totalPrice", totalPrice1);

            // calculate remaining credit after adding
            double remainCredit = money - totalPrice1;
            request.getSession().setAttribute("remainCredit", remainCredit);

            //stop adding to basket when remainCredit <0
            if (remainCredit < 0) {
                request.getSession().setAttribute("Error", "");
            }

            // save basket to session
            request.getSession().setAttribute("basket", basket);

            //  JSP
            request.setAttribute("productsBasket", basket.getBasket());
            request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);

        } catch (Exception e) {
            response.getWriter().append("error " + e.getMessage());
        }
    }
}
