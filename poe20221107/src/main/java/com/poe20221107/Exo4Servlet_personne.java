
package com.poe20221107;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET /personnesession
@WebServlet("/personnesession")
public class Exo4Servlet_personne extends HttpServlet {
    private List<Personne> personnes = new ArrayList<>();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {       
//        // modification session
//        String prenom = request.getParameter("prenom");
//        String nom = request.getParameter("nom");
//        if(prenom != null && nom!= null){
//            Personne personne = new Personne(prenom, nom);
//            request.getSession().setAttribute("personne", personne);
//        }
//        
        // écrire dans le navigateur le contenu de la session
//        Personne p = (Personne)request.getSession().getAttribute("personne");
//        
//        if(p == null){
//            p = new Personne();
//        }
        
        
//        request.setAttribute("personne",p);
        request.getSession().setAttribute("personnes", personnes);
        request.getRequestDispatcher("WEB-INF/personne.jsp").forward(request,response);
        
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        try{
        //recuperation donnees envoyees dans le <form> HTML
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String ageString = request.getParameter("age");
        int ageInt =Integer.parseInt(ageString);
        
        //sauvegarde dans la session
         if(prenom != null && nom!= null){
            Personne personne = new Personne(prenom, nom, ageInt);
            request.getSession().setAttribute("personne", personne);
            //request.setAttribute("personne",personne);
            personnes.add(personne);
        }
         
        // Affichage JSP
        
//        request.getRequestDispatcher("WEB-INF/personne.jsp").forward(request,response);
        
        doGet(request,response); //pour l'affichage de page, on a deja dans le methode doGet
        //il permet d'eviter la repetition de code
        }catch(Exception e){
                response.getWriter().append("<p>erreur dans la formulaire");
                response.getWriter().append("<a href=\"jeunombre\">retour</a>");
        }
    }
}
  
