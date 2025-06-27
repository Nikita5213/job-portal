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
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class downloadServlet extends HttpServlet{
	
	Connection getConnection() throws SQLException  {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	    } 
	    catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal","root" ,"Nikita#54");
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String email;
		
		 if(request.getParameter("email") == null)
		 email = u.getEmail();
		 else
		 email = request.getParameter("email");
		
		String sql = "Select resumeFile from profile where email = ?";
		Connection conn;
	
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, email);
			 ResultSet rs = stmt.executeQuery();
			 
	            if (rs.next()) {
	                Blob resumeBlob = rs.getBlob("resumeFile");
	                InputStream inputStream = resumeBlob.getBinaryStream();
	                response.setContentType("application/pdf");
	                response.setHeader("Content-Disposition", "attachment;filename=\"resume.pdf\"");


	                ServletOutputStream out = response.getOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead;

	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    out.write(buffer, 0, bytesRead);
	                }

	                inputStream.close();
	                out.flush();
	            } else {
	                response.getWriter().println("Resume not found for Email: " + email);
	            }

			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
}