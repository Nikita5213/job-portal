package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
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
		    
//			out.println("<html><head>");
//			out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
//			out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>");
//			out.println("</head><body>");
//		    out.println("<div class='container mt-5'>");
//			out.println("<h1>Job List<table border = '1'></h1>");
//			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th></tr>");
//			for (Job j : list) {
//	                out.println("<tr><td>" + j.getTitle() + "</td><td>" + j.getDescription() + "</td><td>"
//	                        + j.getLocation() + "</td><td>" + j.getSkill() + "</td><td>"+j.getYears() + "</td><td>"+j.getSalary()+ "</td></tr>");
//	            }
//	        out.println("</table>");
//	        out.println("</div>");
//	        out.println("</body></html>");
			
			request.setAttribute("jobList", list); // pass data
			RequestDispatcher rd = request.getRequestDispatcher("job-list.jsp");
			rd.forward(request, response);

		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}