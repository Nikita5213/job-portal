package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.Userdao;
import com.model.Profile;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ApplicantProfileServlet extends HttpServlet{
   Userdao userdao;
	
	public void init() {
		userdao = new Userdao();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		Profile p = new Profile();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String email = request.getParameter("email");
		try {
			p = userdao.getAllDetails(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		out.println("<div>Email:"+p.getEmail()+"</div><br>");
//		out.println("<div>phoneno:"+p.getPhoneno()+"</div><br>");
//		out.println("<div>Education:"+p.getEducation()+"</div><br>");
//		out.println("<div>Experience:"+p.getExperience()+"</div><br>");
//		out.println("<div>Skills:"+p.getSkills()+"</div><br>");
//		out.println("<div>Project"+p.getProject()+"</div><br>");
//		out.println("<div><a href = \"download?email="+p.getEmail()+"\">Download Resume</a></div><br>");
		
		request.setAttribute("List", p); 
		RequestDispatcher rd = request.getRequestDispatcher("showapplicants.jsp");
		rd.forward(request, response);
		
		}
	
}