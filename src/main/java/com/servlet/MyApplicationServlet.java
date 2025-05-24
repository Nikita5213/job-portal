package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.model.Job;
import com.model.Job_application;
import com.model.User;



public class MyApplicationServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Job_application ja = new Job_application();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			int id = u.getId();
			List<Object> list = new ArrayList<>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			list = (List<Object>) userdao.My_Application(id);
			
			out.println("<h1>Job List</h1>");
            out.println("<table border='1'>");
			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th><th>Status</th></tr>");
			for (Object j : list) {
	                out.println("<tr><td>" + ((Job) j).getTitle() + "</td><td>" + ((Job) j).getDescription() + "</td><td>"
	                        + ((Job) j).getLocation() + "</td><td>" + ((Job) j).getSkill() + "</td><td>"+((Job) j).getYears() + "</td><td>"+
	                		((Job) j).getSalary()+"</td><td>"+ ja.getStatus() +"</td></tr>");
	            }
	        out.println("</table>");
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}