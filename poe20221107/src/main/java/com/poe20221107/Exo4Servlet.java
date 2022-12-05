
package com.poe20221107;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET /personnesession?prenom=jean@nom=delon
@WebServlet("/personnesession")
public class Exo4Servlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException
    {       
        // modification session
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        if(prenom != null && nom!= null){
            Personne personne = new Personne(prenom, nom);
            request.getSession().setAttribute("personne", personne);
        }
        
        // écrire dans le navigateur le contenu de la session
        Personne p = (Personne)request.getSession().getAttribute("personne");
        if(p == null){
            p = new Personne();
        }
        response.getWriter().append("<p>Prénom: "+p.getPrenom()+"</p>");
        response.getWriter().append("<p>Nom: "+p.getNom()+"</p>");
        
    }
}
  
