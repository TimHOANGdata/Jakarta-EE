//Exercice phrase magique
//Ecrire une Servlet qui permet à plusieurs joueurs de participer à la construction d’une phrase.
//Quand un joueur envoie un mot, celui-ci s’ajoute à la phrase en cours de construction.
//Exemple:
//début du jeu, la phrase est vide.
//Joueur 1 envoie : “C’est l’histoire”   -> La phrase est “C’est l’histoire”
//Joueur 2 envoie : “d’un enfant” -> La phrase est “C’est l’histoire d’un enfant”
//Joueur 3 envoie : “qui découvre un trésor”   -> La phrase est “C’est l’histoire d’un enfant qui découvre un trésor”
//etc...
package com.poe20221107;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/phrase-magique")
public class Exo2 extends HttpServlet {
    String phraseMagique ="";
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        String phrase = " "+request.getParameter("phrase");
        phraseMagique+=phrase;
        response.getWriter().append("<h1>"+phraseMagique+"<h1>");
        
    }
}
    
