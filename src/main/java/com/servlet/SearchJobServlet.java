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

import com.model.Job;



public class SearchJobServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<Job> list = new ArrayList<>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String search = request.getParameter("search");
			
			list = userdao.searchJobs(search);
			
			out.println("<h1>Job List</h1>");
            out.println("<table border='1'>");
			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th></tr>");
			for (Job j : list) {
	                out.println("<tr><td>" + j.getTitle() + "</td><td>" + j.getDescription() + "</td><td>"
	                        + j.getLocation() + "</td><td>" + j.getSkill() + "</td><td>"+j.getYears() + "</td><td>"+j.getSalary()+ "</td></tr>");
	            }
	        out.println("</table>");
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}