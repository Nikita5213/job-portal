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

import com.model.Job;
import com.model.JobWithApplication;
import com.model.Job_application;
import com.model.User;



public class MyApplicationServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			int id = u.getId();
			List<JobWithApplication> list = new ArrayList<>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			list = userdao.My_Application(id);
			
//			out.println("<h1>Job List</h1>");
//            out.println("<table border='1'>");
//			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th><th>Status</th></tr>");
//			for (JobWithApplication jwa : list) {
//	                out.println("<tr><td>" + jwa.getJob().getTitle() + "</td><td>" + jwa.getJob().getDescription() + "</td><td>"
//	                        + jwa.getJob().getLocation() + "</td><td>" + jwa.getJob().getSkill() + "</td><td>"+jwa.getJob().getYears() + "</td><td>"+
//	                        jwa.getJob().getSalary()+"</td><td>"+ jwa.getApplication().getStatus() +"</td></tr>");
//	            }
//	        out.println("</table>");

			request.setAttribute("myapplication", list); // pass data
			RequestDispatcher rd = request.getRequestDispatcher("myapplication.jsp");
			rd.forward(request, response);
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}