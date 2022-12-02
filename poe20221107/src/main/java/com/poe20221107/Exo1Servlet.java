
package com.poe20221107;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Verb 

@WebServlet("/exo1")
public class Exo1Servlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        int random_int = (int) Math.floor(Math.random() * 11);
        String number = request.getParameter("number");
        int number1 =  Integer.valueOf(number);
        response.getWriter().append("<h1>nombre a deviner: "+random_int+"<h1>");
        if(number1==random_int){
            response.getWriter().append("<h1>fecilitation<h1>");
        }else if(number1>random_int){
                response.getWriter().append("<h1>trop grand<h1>");
                }else{
            response.getWriter().append("<h1>trop petit<h1>");
        }
    }
}

    
