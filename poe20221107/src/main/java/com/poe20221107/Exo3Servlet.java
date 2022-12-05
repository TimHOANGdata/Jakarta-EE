//Le calendrier
//Créer une Servlet qui prend en paramètre le numéro du jour(entre 1 et 7), 
//le numero du mois(entre 1 et 12) et qui affiche dans le navigateur le jour 
//et le mois sous forme textuelle (“Lundi” “décembre”)
package com.poe20221107;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Month;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calendrier")
public class Exo3Servlet extends HttpServlet{
     public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
         String numberJours = request.getParameter("numberJ");
         String numberMois = request.getParameter("numberM");
         int number1 = Integer.parseInt(numberJours);
         int number2 = Integer.parseInt(numberMois);
         DayOfWeek a = DayOfWeek.of(number1);
         Month b = Month.of(number2);
         response.getWriter().append("<h1>"+a+", "+b+"<h1>");
     }
}
