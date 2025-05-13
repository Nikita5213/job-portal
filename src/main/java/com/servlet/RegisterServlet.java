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
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
	try {
	
	User u_one = new User();
	u_one.setName(request.getParameter("Name"));
	u_one.setEmail(request.getParameter("Email"));
	u_one.setPassword(request.getParameter("Password"));
	u_one.setRole(request.getParameter("Role"));
	
	try {
		userdao.RegisterUser(u_one);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	response.sendRedirect("dashboard.jsp");
	}
	catch (IOException e) {
	
		e.printStackTrace();
	}
}
}