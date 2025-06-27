package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.model.User;


public class RegisterServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() {
		userdao = new Userdao();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		try {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setRole(request.getParameter("role"));
			userdao.registerUser(user);
			response.sendRedirect("login.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}