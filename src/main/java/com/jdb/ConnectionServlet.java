package com.jdb;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// load and register driver 
		
		Connection connect = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO userinfo (id , name, age , city) VALUES (?,?,?,?)";
		
		String id = request.getParameter("id");
		String age = request.getParameter("age");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		int _id = Integer.parseInt(id);
		int _age = Integer.parseInt(age);
		
		PrintWriter pr = response.getWriter();
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_learning", "root", "");
			
			statement = connect.prepareStatement(sql);
			
			statement.setInt(1, _id);
			statement.setString(2, name);
			statement.setInt(3, _age);
			statement.setString(4, city);
			
			int ra = statement.executeUpdate();
			
			if (ra == 1) pr.println("Your data was successfully stored in the database");
			else pr.println("Sorry, but something went wrong!");
			
			
		}
		catch (Exception e )
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
			{
				connect.close();
				statement.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
