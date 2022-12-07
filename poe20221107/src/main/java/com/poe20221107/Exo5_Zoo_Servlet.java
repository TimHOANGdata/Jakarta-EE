//TP Zoo:
//Créer une classe Tigre contenant un nom et un pays d'origine et un age pour chaque Tigre
//Créer une Servlet avec 
//    un doGet() qui affiche une JSP. Cette JSP contient un formulaire pour ajouter un Tigre et aussi la liste des tigres
//    un doPost() qui permet de créer le tigre avec les informations envoyées par le <form> HTML
//Créer un JSP qui contient le code HTML (donc pas de code HTML dans la Servlet)
//
//Si on donne un age qui est négatif alors ne pas enregistrer le tigre et afficher un message d'erreur dans le navigateur.
package com.poe20221107;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/zoo")
public class Exo5_Zoo_Servlet extends HttpServlet {
//    List<Tigre> tigres = new ArrayList<>();
    List<Animal> animaux = new ArrayList<>();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        
        request.getSession().setAttribute("animaux",animaux);
        request.getRequestDispatcher("WEB-INF/zoo.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        try{
        String type = request.getParameter("type-animal");
        String pays = request.getParameter("pays");
        String nom = request.getParameter("nom");
        String ageString = request.getParameter("age");
        int ageInt = Integer.parseInt(ageString);
        if (ageInt < 0) {
            request.setAttribute("error", "il faut entrer un age positive");
        }else{
            if(nom != null && pays!= null){
                Animal animal;
                if(type.equals("tigre")){
                    animal = new Tigre(nom, pays, ageInt);
                }else{
                    animal = new Elephant(nom,pays,ageInt); 
                }
            request.getSession().setAttribute("animal", animal);
            animaux.add(animal);
            }
        }
//        if (nom.equals("")){
//            request.setAttribute("error1"," veuillez entrer nom du tigre");
//        }
//        if (pays.equals("")){
//            request.setAttribute("error2","veuillez entrer pays du tigre");
//        }
        
        
        doGet(request,response);
        
//       
        
        }catch(Exception e){
            request.setAttribute("error", "erreur de saisir dans le formulaire");
            doGet(request,response);
        }
        
    }
}
