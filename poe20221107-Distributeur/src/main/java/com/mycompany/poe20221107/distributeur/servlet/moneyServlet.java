
package com.mycompany.poe20221107.distributeur.servlet;

import com.mycompany.poe20221107.distributeur.model.Stock;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/money")
public class moneyServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String moneyString = request.getParameter("moneyString");
            
            if(moneyString.equals("")){
                moneyString =(String) request.getSession().getAttribute("moneyString1");
            }else{
                request.getSession().setAttribute("moneyString1", moneyString);
                
            }
            double money = Double.parseDouble(moneyString);
            request.getSession().setAttribute("moneyDouble", money);
            Stock stock = (Stock) request.getSession().getAttribute("stock");
            request.setAttribute("stock", stock.getStock());
            request.getRequestDispatcher("WEB-INF/distributeur.jsp").forward(request, response);
        
    }catch(Exception e){
        
    }
}
}
