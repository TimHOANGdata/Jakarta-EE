
package com.poe20221107;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class querryParamServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        
        String prenom = request.getParameter("prenom");
        response.getWriter().append("<p>tu t'appelles</p>");
        response.getWriter().append("<p>"+prenom+"</p>");
    }
}
//Utiliser query param pour les request dynamique.
//http://localhost:8080/poe20221107/param?prenom=Tim