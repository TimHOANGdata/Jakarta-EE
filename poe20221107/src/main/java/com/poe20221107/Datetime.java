
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/datetime")
public class Datetime extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException 
    {
        LocalDateTime madate = LocalDateTime.now();
        response.getWriter().write("<h1>"+madate+"</h1>");
    }
}
