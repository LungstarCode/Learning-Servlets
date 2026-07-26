

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServletClass
 */
@WebServlet("/firstServlet")

public class FirstServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public FirstServletClass() {
        
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head><title>Servlet Response</title></head>");
		writer.println("<body><h1>" + name + " You are from " + city + "</h1></body>");
		writer.println("</html>");
		
		writer.close();
		
	}

}
