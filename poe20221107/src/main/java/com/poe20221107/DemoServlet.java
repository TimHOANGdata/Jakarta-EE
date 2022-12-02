package com.poe20221107;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Verb 

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        System.out.println("debut du doGet");
        
        response.getWriter().write("<h1>Bonjour</h1>");
        //getWriter() permets de envoyer le string au client
        //sout: print message sur le console
       
        System.out.println("fin du doGet()");
    }
}

