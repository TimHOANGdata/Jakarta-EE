
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
        if(prenom == null){
             prenom = (String)request.getSession().getAttribute("prenomDansLaSession");
        //getAtrribute retourne object donc il faut un cast en String
        //getAttribute permet de retourner l'identifiant enrégistré
        }
        request.getSession().setAttribute("prenomDansLaSession",prenom);
        //setAtrribute permet d'enregistrer l'identifiant dans le cookie
        response.getWriter().append("<p>tu t'appelles</p>");
        response.getWriter().append("<p>"+prenom+"</p>");
    }
}
