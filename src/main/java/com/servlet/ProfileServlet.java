package com.servlet;
import com.dao.Userdao;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
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
			User u1 = new User();
			
			Part filePart = request.getPart("resumeFile");
			InputStream fileInputStream = filePart.getInputStream();
			 
			
			String email = u.getEmail();
			p1 = userdao.getAllDetails(email);
			
			
			p.setEmail(request.getParameter("email"));
			p.setPhoneno((Integer.parseInt(request.getParameter("phoneno"))));
			p.setEducation(request.getParameter("education"));
			p.setExperience((Integer.parseInt(request.getParameter("experience"))));
			p.setSkills(request.getParameter("skills"));
			p.setProject(request.getParameter("project"));
			p.setResumeFile(fileInputStream);	
			
			u1.setName(request.getParameter("name"));
			u1.setEmail(request.getParameter("email"));
			
			if(p1 == null) {
				userdao.insertAllDetails(p);
			}
			else {
				if (!(filePart != null && filePart.getSize() > 0)) {
					p.setResumeFile(null);	
				}
				userdao.updateAllDetails(p);
			}	
			userdao.updateName(u1);
			u.setName(request.getParameter("name"));
			session.setAttribute("user",u);
			
		   
			
			
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
			String name = u.getName();
			String email = u.getEmail();
			String role = u.getRole();
			p = userdao.getAllDetails(email);
		      
//	        out.println("<form action=\"profile\" method=\"post\" enctype=\"multipart/form-data\">");
//	        out.println("Name: <input type = \"text\" name = \"name\"  value = \"" +name+ "\"><br><br>");
//	        out.println("Email: <input type = \"email\" name = \"email\" readonly value = \"" +email+"\"><br><br>");
//	        out.println("PhoneNo: <input type = \"number\" name = \"phoneno\" value = \""+(p == null ? " " : p.getPhoneno())+"\"><br><br>");
//	        out.println("Education: <input type = \"text\" name = \"education\" value=  \""+(p == null ? " " : p.getEducation())+"\"><br><br>");
//	        out.println("Experience: <input type = \"text\" name = \"experience\" value= \""+(p == null? " " :p.getExperience())+"\"><br><br>");
//	        out.println("Skills: <input type = \"text\" name = \"skills\" value=  \""+(p == null ? " " : p.getSkills())+"\"><br><br>");
//	        out.println("Project: <input type = \"text\" name = \"project\" value=  \""+(p == null ? " " : p.getProject())+"\"><br><br>");
//	        out.println("Resume: <input type = \"file\" style=\"WIDTH: 200PX\" name = \"resumeFile\">");
//	        if(p!= null) {
//	        	out.println("<a href = \"download\">Download</a>");
//	        }
//	       
//	        
//	        out.println("<br><br><button value = \"submit\">Submit</button>");
//		    out.println("</form>");
			
			request.setAttribute("profile",p);
			if(u.getRole().equalsIgnoreCase("employer")) {
			RequestDispatcher rd = request.getRequestDispatcher("profile_emp.jsp");
			rd.forward(request, response);
			}
			else {
			RequestDispatcher rd = request.getRequestDispatcher("profile_app.jsp");
			rd.forward(request, response);
			}	

		    
		}		catch (Exception e) {

			e.printStackTrace();
		}
	}
}
