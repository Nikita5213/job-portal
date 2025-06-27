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
import com.model.Profile;
import com.model.User;



public class RecommendedJobServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<Job> list = new ArrayList<>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Profile p = new Profile();
		
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			
			int id  = u.getId();
			String email = u.getEmail();
			p = userdao.getAllDetails(email);
			
			list = userdao.recommendJobs(id,p.getSkills().trim());
			
//			out.println("<h1>Job List</h1>");
//            out.println("<table border='1'>");
//			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th></tr>");
//			for (Job j : list) {
//	                out.println("<tr><td>" + j.getTitle() + "</td><td>" + j.getDescription() + "</td><td>"
//	                        + j.getLocation() + "</td><td>" + j.getSkill() + "</td><td>"+j.getYears() + "</td><td>"+j.getSalary()+
//	                        "<a href = \"apply?job_id="+j.getId()+"\"><button value = \"submit\">Apply </button>"+"</a>"+"</td></tr>");
//	            }
//	        out.println("</table>");

			request.setAttribute("recommendlist", list); // pass data
			RequestDispatcher rd = request.getRequestDispatcher("recommend.jsp");
			rd.forward(request, response);
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}