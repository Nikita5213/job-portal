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
import com.model.Job;

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
		System.out.println(j.getTitle());
		System.out.println(j.getDescription());
		System.out.println(j.getLocation());
		System.out.println(j.getSkill());
		System.out.println(j.getYears());
		System.out.println(j.getSalary());
		list.add(j);
		}
		return list;
	}
	
	
public List<Job> searchJobs(String search) throws SQLException {
		
		List<Job> list = new ArrayList<>();
		String sql = "SELECT * FROM jobs WHERE title LIKE ? OR skill LIKE ? OR years LIKE ? OR location LIKE ? ";
		Connection conn;
		conn = getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + search + "%");
        stmt.setString(2, "%" + search + "%");
        stmt.setString(3, "%" + search + "%");
        stmt.setString(4, "%" + search + "%");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
		Job j = new Job();
		j.setTitle(rs.getString("title"));
		j.setDescription(rs.getString("description"));
		j.setLocation(rs.getString("location"));
		j.setSkill(rs.getString("skill"));
		j.setYears(rs.getInt("years"));
		j.setSalary(rs.getInt("salary"));
		System.out.println(j.getTitle());
		System.out.println(j.getDescription());
		System.out.println(j.getLocation());
		System.out.println(j.getSkill());
		System.out.println(j.getYears());
		System.out.println(j.getSalary());
		
		list.add(j);
		}
		return list;
	}

	
}