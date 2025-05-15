package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.User;

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
	
	public String loginUser(User u) throws SQLException{
		
			String sql = "Select * from users where email = ? and password = ?";
			Connection conn;
		
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,u.getEmail());
			stmt.setString(2,u.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String role = rs.getString("role");
			   return role;
			}
			else {
				return null;
			}
		}
}