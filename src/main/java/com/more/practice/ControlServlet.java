package com.more.practice;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username;
		String password;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(30000);
		session.setAttribute("password", password);
		session.setAttribute("username", username);
		
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/ResponseServlet");
		reqDispatcher.include(request, response);
		
		System.out.println("In control Servlet"); // just for debuging
		
		
		
	}

}
