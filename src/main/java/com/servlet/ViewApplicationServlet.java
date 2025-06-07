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


import com.model.User;
import com.model.ViewApplication;



public class ViewApplicationServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			HttpSession session = request.getSession();
			List<ViewApplication> list = new ArrayList<>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			User u = (User)session.getAttribute("user");

			String Post = u.getEmail();
			list = userdao.View_Application(Post);
			
			out.println("<h1>Job List</h1>");
            out.println("<table border='1'>");
			out.println("<tr><th>Name</th><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th></tr>");
			for (ViewApplication va : list) {
	                out.println("<tr><td>" +  va.getUser().getName() + "</td><td>" + va.getJob().getTitle() + "</td><td>" + va.getJob().getDescription()
	                		+ "</td><td>"  + va.getJob().getLocation() + "</td><td>" + va.getJob().getSkill() + "</td><td>"+va.getJob().getYears() + "</td><td>"+
	                        va.getJob().getSalary()+"</td><td><a href = \"profile.jsp\"><button value = \"submit\">View</button></td></tr>");
	               }
			
	        out.println("</table><br>");
	       
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	