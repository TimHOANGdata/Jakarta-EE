// Créer une Servlet jeu du nombre à deviner.  
// La servlet reçoit le nombre proposé par le joueur, puis calcule un nombre aléatoire entre 1 et 10,
// puis affiche dans la page web : gagné ou trop grand ou trop petit.
// Permettre au joueur de deviner avec plusieurs tentatives.
//-> déplacer le int nombreADeviner dans la classe
//-> Puis démarrer une nouvelle partie chaque fois qu’on a gagné.
//    re-affecter la valeur
//-> limiter le nombre de tentatives autorisées pour chaque partie
package com.poe20221107;

import java.io.IOException;

import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET /jeunombre?nombre=5
@WebServlet("/jeunombre")
public class Exo1Servlet_number extends HttpServlet {
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // On récupère les informations de la partie stocké dans la Session
        Integer nombreADeviner = (Integer) request.getSession().getAttribute("nombreADeviner");
        Integer nombreTentativesRestantes = (Integer) request.getSession().getAttribute("nombreTentativesRestantes");
        Integer nombreJoueur = (Integer) request.getSession().getAttribute("nombreJoueur");

        // Initialisation de la partie
        if (nombreADeviner == null) {
            nombreADeviner = new Random().nextInt(1, 11);
            nombreTentativesRestantes = 3;
            request.getSession().setAttribute("nombreTentativesRestantes", nombreTentativesRestantes);
            request.getSession().setAttribute("nombreADeviner", nombreADeviner);
        }
        
        response.getWriter().append("<p>Nombre à deviner: " + nombreADeviner + "</p>");
        response.getWriter().append("<p>Nombre joué: " + nombreJoueur + "</p>");
        response.getWriter().append("<p>Nombre tentatives restantes: " + nombreTentativesRestantes + "</p>");

        // Ajout du form
        response.getWriter().append("<form action=\"jeunombre\" method=\"POST\">");
        response.getWriter().append("<label>Votre proposition:</label>");
        response.getWriter().append("<input type=\"text\" name=\"nombre\"/>");
        response.getWriter().append("<input  type=\"submit\" value=\"Jouer\"/>");
        response.getWriter().append("</form>");

        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            // On récupère la proposition du joueur 
            String nombreJoueurString = request.getParameter("nombre");
            int nombreJoueur = Integer.parseInt(nombreJoueurString);

            // On récupère les informations de la partie stocké dans la Session
            Integer nombreADeviner = (Integer) request.getSession().getAttribute("nombreADeviner");
            Integer nombreTentativesRestantes = (Integer) request.getSession().getAttribute("nombreTentativesRestantes");

            // Algo du jeu
            nombreTentativesRestantes--;

            if (nombreJoueur == nombreADeviner) {
                response.getWriter().append("<p>Bravo c'est gagné !</p>");
                response.getWriter().append("<p>Nouvelle partie démarrée</p>");
                nombreADeviner = new Random().nextInt(1, 11);
                nombreTentativesRestantes = 3;
            } else {
                if (nombreJoueur > nombreADeviner) {
                    response.getWriter().append("<p>c'est trop grand</p>");
                } else {
                    response.getWriter().append("<p>c'est trop petit</p>");
                }

                if (nombreTentativesRestantes == 0) {
                    response.getWriter().append("<p>PERDU, nombre de tentatives maximum atteint</p>");
                    response.getWriter().append("<p>Nouvelle partie démarrée</p>");
                    nombreADeviner = new Random().nextInt(1, 11);
                    nombreTentativesRestantes = 3;
                }
            }

            // Sauvegarde partie dans la Session
            request.getSession().setAttribute("nombreADeviner", nombreADeviner);
            request.getSession().setAttribute("nombreTentativesRestantes", nombreTentativesRestantes);
            request.getSession().setAttribute("nombreJoueur", nombreJoueur);

            doGet(request, response);
        } catch (NumberFormatException e) {
            response.getWriter().append("<p>Erreur : Veuillez saisir un nombre</p>");
            response.getWriter().append("<a href=\"jeunombre\">Revenir à la partie</a>");
        }
    }

}