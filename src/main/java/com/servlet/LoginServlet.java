package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.Userdao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	
	boolean b;
	Userdao userdao;
	
	public void init() {
		userdao = new Userdao();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		try {
			b = userdao.loginUser(user);
			if(b== true)
			response.sendRedirect("dashboard.jsp");
			else {
				out.println("<h1>Error occurred!</h1>");
				out.println("<a href = \"login.jsp\"> Try again</a>");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}