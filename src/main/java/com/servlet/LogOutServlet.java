package com.servlet;

import java.io.IOException;
import com.dao.Userdao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		try {
		 
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	            response.sendRedirect("login.jsp");
	        }
	     
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}