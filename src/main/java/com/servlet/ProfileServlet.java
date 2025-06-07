package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import com.model.Job;
import com.model.Profile;
import com.model.User;


@MultipartConfig     
public class ProfileServlet extends HttpServlet{
	
	Userdao userdao;
	
	public void init() throws ServletException {
		userdao = new Userdao();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Profile p1 = new Profile();
			Profile p = new Profile();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			
			String email = u.getEmail();
			p1 = userdao.getAllDetails(email);
			
			p.setName(request.getParameter("name"));
			p.setEmail(request.getParameter("email"));
			p.setPhoneno((Integer.parseInt(request.getParameter("phoneno"))));
			p.setEducation(request.getParameter("education"));
			p.setExperience((Integer.parseInt(request.getParameter("experience"))));
			p.setSkills(request.getParameter("skills"));
			p.setProject(request.getParameter("project"));
			
			if(p1 == null) {
				userdao.insertAllDetails(p);
				}
				else {
				userdao.updateAllDetails(p);
				}	
			
		    //Part filePart = request.getPart("resumefile");
		    //InputStream fileInputStream = filePart.getInputStream();
		 
			
			//p.setResumeFile(fileInputStream);	
			response.sendRedirect("profile");
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Profile p = new Profile();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			
			String email = u.getEmail();
			p = userdao.getAllDetails(email);
		      
	        out.println("<form action=\"profile\" method=\"post\">");
	        out.println("Name: <input type = \"text\" name = \"name\"  value = " +(p== null ? " ": p.getName())+"><br><br>");
	        out.println("Email: <input type = \"email\" name = \"email\" disabled value = " +email+"><br><br>");
	        out.println("PhoneNo: <input type = \"number\" name = \"phoneno\" value = "+(p == null ? " " : p.getPhoneno())+"><br><br>");
	        out.println("Education: <input type = \"text\" name = \"education\" value=  "+(p == null ? " " : p.getEducation())+"><br><br>");
	        out.println("Experience: <input type = \"text\" name = \"experience\" value=  "+(p == null? " " :p.getExperience())+"><br><br>");
	        out.println("Skills: <input type = \"text\" name = \"skills\" value=  "+(p == null ? " " : p.getSkills())+"><br><br>");
	        out.println("Project: <input type = \"text\" name = \"project\" value=  "+(p == null ? " " : p.getProject())+"><br><br>");
	        out.println("<button value = \"submit\">Submit</button>");
		    out.println("</form>");
		    
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}
