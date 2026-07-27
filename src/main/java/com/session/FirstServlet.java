package com.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/FirstServletSession")
public class FirstServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/SecondServletSession");
		reqDispatcher.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(20000);
		
		
		
		
	}

}
