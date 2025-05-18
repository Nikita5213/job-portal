package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.Job;



public class PostJobServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() {
		userdao = new Userdao();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
			Job job = new Job();
			job.setTitle(request.getParameter("title"));
			job.setDescription(request.getParameter("description"));
			job.setLocation(request.getParameter("location"));
			job.setPostedBy(request.getParameter("postedBy"));
			job.setSkill(request.getParameter("skill"));
			job.setYears((Integer.parseInt(request.getParameter("years"))));
			job.setSalary((Integer.parseInt(request.getParameter("salary"))));
			
			try {
				int rows;
				rows = userdao.postJob(job);
				if(rows>0)
					response.sendRedirect("view-my-list");
				else
					out.println("<h1>Failed to post job.</h1>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}