package com.more.practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In the dispatcher Servlet");
		HttpSession session = request.getSession(false);
		PrintWriter wr = response.getWriter();
		
		if (session != null) {
			wr.println("Hello "+ session.getAttribute("username") + " You are welcome to the app, your password is "+ session.getAttribute("password"));
		}
		
		else wr.println("Sorry, session not found");
	}

}
