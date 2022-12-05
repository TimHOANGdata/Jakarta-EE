
package com.poe20221107;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET /personnesession?prenom=jean@nom=delon
@WebServlet("/personnesession")
public class Exo4Servlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
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
        request.setAttribute("a",p.getNom());
        request.setAttribute("b",p.getPrenom());
        request.setAttribute("personne",p.toString());
        request.getRequestDispatcher("WEB-INF/personne.jsp").forward(request,response);
        
    }
}
  
