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
import java.util.HashSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Verb 

@WebServlet("/exo1")
public class Exo1Servlet extends HttpServlet{
//    int random_int = (int) Math.floor(Math.random() * 11);
    int nombreDeTentative =4;
//    int tentative = 0;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        
        String number = request.getParameter("number");
       
            try{
            // On recupère la position du joueur
            int number1 =  Integer.parseInt(number);
            
            //on recupere les informations de la partie stocké dans la session
            Integer random_int = (Integer) request.getSession().getAttribute("random_int"); 
            Integer tentative = (Integer) request.getSession().getAttribute("tentative");
            
           // Initialisation de la partie
           if(random_int == null){
               random_int = (int) Math.floor(Math.random() * 11);
               tentative = 0;
           }
            response.getWriter().append("<h1>nombre a deviner: "+random_int+"<h1>");
            
            if(tentative < nombreDeTentative){
                
                if(number1==random_int){
                    response.getWriter().append("<h1>fecilitation, gagné<h1>");
                    tentative = 0;
                    random_int = (int) Math.floor(Math.random() * 11);
                    response.getWriter().append("<h1>veuillez saisir un nombre pour recommencer<h1>");
                    
                }else{
                    if(number1>random_int){
                    response.getWriter().append("<h1>trop grand<h1>");
                    
                    }else{
                    response.getWriter().append("<h1>trop petit<h1>");
                    }response.getWriter().append("<h1>il vous reste :" + (nombreDeTentative-tentative)+"tentatives<h1>");
                }
            }else{
                if(number1==random_int){
                     response.getWriter().append("<h1>fecilitation, gagné<h1>");
                }else{
                    response.getWriter().append("<h1>vous avez perdu<h1>");
                }
                tentative =0;
                random_int = (int) Math.floor(Math.random() * 11);
                response.getWriter().append( "<h1>veuillez saisir un nombre pour recommencer<h1>");
                
            }tentative++;
            request.getSession().setAttribute("random_int",random_int);
            request.getSession().setAttribute("tentative", tentative);
            
                
        }catch(NumberFormatException e){
            response.getWriter().append("<h1>erreur, il faut entrer un nombre <h1>");
        }
    }
}
    
