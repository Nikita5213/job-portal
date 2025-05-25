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
import com.model.Profile;
import com.model.User;



public class ProfileServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Profile p = new Profile();
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			
			String email = u.getEmail();
			p = userdao.getAllDetails(email);
			
			out.println("<h1>Profile<table border = '1'></h1>");
			out.println("<tr><th>Title</th><th>Description</th><th>Location</th><th>Skill</th><th>Years</th><th>Salary</th></tr>");
			
	        out.println("<tr><td>" + p.getName() + "</td><td>" + p.getEmail() + "</td><td>" + p.getPhoneno() + "</td><td>" + p.getEducation() 
	        + "</td><td>"+p.getExperience() + "</td><td>"+p.getSkills()+"</td><td>"+ p.getProject()+"</td><td>"+
	        		p.getResumelink()+"</td><td>"+p.getCertificates() + "</td></tr>");
	            
	        out.println("</table>");
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}