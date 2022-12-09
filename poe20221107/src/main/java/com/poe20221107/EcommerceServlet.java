package com.poe20221107;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eCommerce")
public class EcommerceServlet extends HttpServlet {

    Produit a = new Produit("1", "a", 3, 3);
    Produit b = new Produit("2", "b", 5, 4);
    Produit c = new Produit("3", "c", 9, 5);
    Produit d = new Produit("4", "d", 3, 4);
    Produit e = new Produit("5", "e", 3, 3);
    Produit f = new Produit("6", "f", 10, 3);
    Produit g = new Produit("7", "g", 12, 3);
    Produit h = new Produit("8", "h", 4, 3);
    Produit i = new Produit("9", "i", 9, 3);
    Produit k = new Produit("10", "k", 3, 3);

    public List<Produit> Stock() {
        List<Produit> stock = new ArrayList<>();
        stock.add(a);
        stock.add(b);
        stock.add(c);
        stock.add(d);
        stock.add(e);
        stock.add(f);
        stock.add(g);
        stock.add(h);
        stock.add(i);
        stock.add(k);
        return stock;
    }
    List<Produit> stock = Stock();

    double sum = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("stock", stock);
        request.getRequestDispatcher("WEB-INF/eCommerce.jsp").forward(request, response);
      
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String quantiteString = request.getParameter("quantite");

            String produitAjouteId = request.getParameter("produitAjouteId");
            int quantiteInt = Integer.parseInt(quantiteString);
            request.getSession().setAttribute("quantite", quantiteString);
            request.getSession().setAttribute("produitAjouteId", produitAjouteId);
            

            if (quantiteString != null && produitAjouteId != null) {
                for (Produit i : stock) {
                    if (produitAjouteId.equals(i.getId())) {
                        if (i.getQuantite() >= quantiteInt) {
                            i.setQuantite(i.getQuantite() - quantiteInt);
//                            
//                                if(!produitAjouteId.equals(j.getId())){
//                                    Produit produitAjoute = new Produit(i.getId(), i.getNom(), quantiteInt, i.getPrix());
//                                    panier.add(produitAjoute);
//                                    request.getSession().setAttribute("panier", panier);
//                                    request.getSession().setAttribute("produitAjoute", produitAjoute);
//                                }else{
//                                    j.setQuantite(j.getQuantite()+quantiteInt);
//                                    request.getSession().setAttribute("panier", panier);
//                                    
//                                }
//                            }
                            Produit produitAjoute = new Produit(i.getId(), i.getNom(), quantiteInt, i.getPrix());
                            List<Produit> panier = (List<Produit>) request.getSession().getAttribute("panier");
                            if(panier == null){
                                panier = new ArrayList<>();
                            }
                            panier.add(produitAjoute);
                            request.getSession().setAttribute("panier", panier);
                            for (Produit j:panier){
                                sum += j.getQuantite() * j.getPrix();
                                request.getSession().setAttribute("sum", sum);}

                        } else {
                            request.getSession().setAttribute("error", "quantite insuffisante");

                        }

                    }
                }
            }
        
            doGet(request, response);

        } catch (Exception e) {
            response.getWriter().append("<p>erreur dans la formulaire");
            response.getWriter().append("<a href=\"eCommerce\">retour</a>");
            doGet(request, response);
        }
    }
}
