package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.model.User;



public class ApplyJobServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			User loginuser = new User();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			int job_id =(Integer.parseInt(request.getParameter("job_id")));
			System.out.println(job_id);
			
			HttpSession session = request.getSession();
		
			User u = (User)session.getAttribute("user");
			int user_id = u.getId();
			
			System.out.println(user_id);
			int row = userdao.applyJobs(user_id,job_id);
			
			if(row > 0) {
				
				RequestDispatcher rd = request.getRequestDispatcher("applied.jsp");
				rd.forward(request, response);

				//out.println("<p>Applied Successfully</p>");
			}
			
			else {
				out.println("Not Applied");
			}
			
		 }		catch (Exception e) {

			e.printStackTrace();
		}
	}
}