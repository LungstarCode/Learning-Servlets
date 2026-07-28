package com.jdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RetriveServlet")
public class RetriveServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement statement = null;
		Connection conn = null;
		PrintWriter pr = response.getWriter();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_learning", "root", "");
			
			String sql= "SELECT * FROM userinfo";
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) 
			{
				pr.println("The id is "+ rs.getInt(1));
				pr.println("The name is "+ rs.getString(2));
				pr.println("The id age "+ rs.getInt(3));
				pr.println("The id city "+ rs.getString(4));
				pr.println();
				pr.println("____________________________________________________");
			}
			
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				statement.close();
				conn.close();
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
