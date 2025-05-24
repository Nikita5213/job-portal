package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.model.Job;
import com.model.User;


public class JobListServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		try {
			
			List<Job> list = new ArrayList<>();
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			
			String Post = u.getEmail();
			list = userdao.getAllJobs(Post);
			
			out.println("<h1>Job List<table border = '1'></h1>");
			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th><th>Salary</th></tr>");
			for (Job j : list) {
	                out.println("<tr><td>" + j.getTitle() + "</td><td>" + j.getDescription() + "</td><td>"
	                        + j.getLocation() + "</td><td>" + j.getSkill() + "</td><td>"+j.getYears() + "</td><td>"+j.getSalary()+"</td><td>"+ "</td></tr>");
	            }
	        out.println("</table>");
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}