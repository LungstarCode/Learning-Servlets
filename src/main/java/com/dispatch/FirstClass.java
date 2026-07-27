package com.dispatch;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@WebServlet("/FirstClass")
public class FirstClass extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/SecondClass");
		
		// reqDispatcher.forward(request, response);
		reqDispatcher.include(request, response);
		
		PrintWriter write = response.getWriter();
		
		write.println("Back to the Fist Servlet since we are using Inlude");
		
		
		
	}

}
