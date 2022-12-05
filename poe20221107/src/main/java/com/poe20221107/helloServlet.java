package com.poe20221107;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class helloServlet extends HttpServlet{

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException 
    {   LocalDateTime time = LocalDateTime.now();
        
        request.setAttribute("horaire",time);
        
        request.getRequestDispatcher("WEB-INF/hello.jsp").forward(request,response);
      
      
    }
}