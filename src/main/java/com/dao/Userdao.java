package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.model.ViewApplication;

import jakarta.servlet.http.HttpSession;

import com.model.Job;
import com.model.JobWithApplication;
import com.model.Job_application;
import com.model.Profile;
import com.model.Search;

public class Userdao{

	
	Connection getConnection() throws SQLException  {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	    } 
	    catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal","root" ,"Nikita#54");
	}
	
	public void registerUser(User r) {
	    String sql = "INSERT INTO users (name,email,password,role) VALUES (?,?,?,?)";
	    Connection conn;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, r.getName());
	        stmt.setString(2, r.getEmail());
	        stmt.setString(3, r.getPassword());
	        stmt.setString(4, r.getRole());
	        stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
	
	public User loginUser(User u) throws SQLException{
		
			String sql = "Select * from users where email = ? and password = ?";
			Connection conn;
		
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1,u.getEmail());
			stmt.setString(2,u.getPassword());
			ResultSet rs = stmt.executeQuery();
			User loginuser = new User();
			
			if(rs.next()) {
				loginuser.setName(rs.getString("name"));
				loginuser.setId(rs.getInt("Id"));
				loginuser.setEmail(rs.getString("email"));
				loginuser.setRole(rs.getString("role"));
			   return loginuser;
			}
			else {
				return null;
			}
		}
	public int postJob(Job j) throws SQLException{
			
		String sql = "INSERT INTO jobs(title,description,location,postedBy,skill,years,salary) VALUES(?,?,?,?,?,?,?)";
		Connection conn;
		conn = getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1,j.getTitle());
		stmt.setString(2,j.getDescription());
		stmt.setString(3,j.getLocation());
		stmt.setString(4,j.getPostedBy());
		stmt.setString(5,j.getSkill());
		stmt.setLong(6,j.getYears());
		stmt.setLong(7,j.getSalary());
		int rows = stmt.executeUpdate();
		if(rows > 0)
			return rows;
		else 
			return 0;
		
	}
	public List<Job> getAllJobs(String Post) throws SQLException {

		
		List<Job> list = new ArrayList<>();
		String sql = "SELECT * FROM jobs WHERE postedBy = ?";
		Connection conn;
		conn = getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,Post);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
		Job j = new Job();
		j.setTitle(rs.getString("title"));
		j.setDescription(rs.getString("description"));
		j.setLocation(rs.getString("location"));
		j.setSkill(rs.getString("skill"));
		j.setYears(rs.getInt("years"));
		j.setSalary(rs.getInt("salary"));
	
		list.add(j);
		}
		return list;
	}
	
	
public List<Job> searchJobs(Search search) throws SQLException {
	
		
		List<Job> list = new ArrayList<>();
		String sql = "SELECT * FROM jobs j LEFT JOIN job_applications ja on j.id = ja.job_id and ja.user_id = ?"
				+ " WHERE (title LIKE ? OR skill LIKE ? OR years LIKE ? OR location LIKE ?) "
				+ "AND status IS NULL";

		Connection conn;
		conn = getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1,search.getUser_id());
		stmt.setString(2, "%" + search.getTitle() + "%");
        stmt.setString(3, "%" + search.getSkills() + "%");
        stmt.setString(4, "%" + search.getYears() + "%");
        stmt.setString(5, "%" + search.getLocation() + "%");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
		Job j = new Job();
		j.setId(rs.getInt("id"));
		j.setTitle(rs.getString("title"));
		j.setDescription(rs.getString("description"));
		j.setLocation(rs.getString("location"));
		j.setSkill(rs.getString("skill"));
		j.setYears(rs.getInt("years"));
		j.setSalary(rs.getInt("salary"));
		
		list.add(j);	
		}
		return list;
	}

public int applyJobs(int user_id,int job_id) throws SQLException {
	
	Job_application j = new Job_application();
	String sql = "INSERT INTO job_applications (job_id,user_id,status) VALUES (?,?,?)";
	Connection conn;
	conn = getConnection();
	
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	stmt.setLong(1,job_id);
	stmt.setLong(2,user_id);
	stmt.setString(3,"Applied");
		int rows = stmt.executeUpdate();
	if(rows>0) {
		return rows;
	}
	else 
		return 0;
}

public List<JobWithApplication> My_Application(int id) throws SQLException {
    List<JobWithApplication> list = new ArrayList<>();
    String sql = "SELECT * FROM job_applications ja LEFT JOIN jobs j ON ja.job_id = j.id WHERE user_id = ?";
    
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Job_application ja = new Job_application();
            ja.setStatus(rs.getString("status"));
      

            Job j = new Job();
            j.setTitle(rs.getString("title"));
            j.setDescription(rs.getString("description"));
            j.setLocation(rs.getString("location"));
            j.setSkill(rs.getString("skill"));
            j.setYears(rs.getInt("years"));
            j.setSalary(rs.getInt("salary"));

            list.add(new JobWithApplication(j, ja));
        }
    }
    return list;
}

public List<ViewApplication> View_Application(String post) throws SQLException {
    List<ViewApplication> list = new ArrayList<>();
    
    String sql = "Select j.title,j.skill,j.years,j.salary,j.description,j.location,u.name from jobs j "
    		+ "JOIN job_applications ja on ja.job_id = j.id JOIN users u on ja.user_id = u.id where postedBy = ?;";
    
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, post);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	User u = new User();
        	u.setName(rs.getString("name"));
            Job j = new Job();
            j.setTitle(rs.getString("title"));
            j.setDescription(rs.getString("description"));
            j.setLocation(rs.getString("location"));
            j.setSkill(rs.getString("skill"));
            j.setYears(rs.getInt("years"));
            j.setSalary(rs.getInt("salary"));

            list.add(new ViewApplication(u, j));
        }
    }
    return list;
}
public void insertAllDetails(Profile p) throws SQLException{
	
	String sql = "Insert into profile (name,email,phoneno,education,experience,skills,project)values(?,?,?,?,?,?,?)";
	Connection conn;

	conn = getConnection();
	PreparedStatement stmt = conn.prepareStatement(sql);

	stmt.setString(1,p.getName());
	stmt.setString(2,p.getEmail());
	stmt.setLong(3,p.getPhoneno());
	stmt.setString(4,p.getEducation());
	stmt.setLong(5,p.getExperience());
	stmt.setString(6,p.getSkills());
	stmt.setString(7,p.getProject());
	stmt.executeUpdate();
	
}
public Profile getAllDetails(String email) throws SQLException{
	
	String sql = "Select * from profile where email = ? ";
	Connection conn;

	conn = getConnection();
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	stmt.setString(1,email);

	ResultSet rs = stmt.executeQuery();
	Profile p = new Profile();
	
	
	if (rs.next()) {
        
        p.setName(rs.getString("name"));
        p.setEmail(rs.getString("email"));
        p.setPhoneno(rs.getInt("phoneno"));
        p.setEducation(rs.getString("education"));
        p.setExperience(rs.getInt("experience"));
        p.setSkills(rs.getString("skills"));
        p.setProject(rs.getString("project"));
       // p.setResumeFile( rs.getBinaryStream("resumefile"));
        return p;
      }
	return null;
}

public List<Job> RecommendJobs(String skills) throws SQLException {

	
	List<Job> list = new ArrayList<>();
	String sql = "SELECT * FROM jobs WHERE skills LIKE  = ?";
	Connection conn;
	conn = getConnection();
	
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setString(1,"%" + skills + "%");
	ResultSet rs = stmt.executeQuery();
	
	while(rs.next()) {
	Job j = new Job();
	j.setTitle(rs.getString("title"));
	j.setDescription(rs.getString("description"));
	j.setLocation(rs.getString("location"));
	j.setSkill(rs.getString("skill"));
	j.setYears(rs.getInt("years"));
	j.setSalary(rs.getInt("salary"));

	list.add(j);
	}
	return list;
}

public void updateAllDetails(Profile p)throws SQLException {
	
	
	
    String sql = "UPDATE profile SET name = ?,phoneno = ?,education = ?,experience = ?,skills = ?,project = ? WHERE email = ?";
    Connection conn;

	conn = getConnection();
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	stmt.setString(1, p.getName());
	stmt.setLong(2,p.getPhoneno());
	stmt.setString(3,p.getEducation());
	stmt.setLong(4,p.getExperience());
	stmt.setString(5,p.getSkills());
	stmt.setString(6,p.getProject());
	stmt.setString(7,p.getEmail());
	stmt.executeUpdate();
}
}
