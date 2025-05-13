package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
		public void RegisterUser(User r) throws SQLException,IOException {
			
        String sql = "INSERT INTO users (Name,Email,Password,Role) VALUES (?,?,?,?)";
        Connection conn = getConnection(); 
        PreparedStatement stmt = conn.prepareStatement(sql);
           
         
            stmt.setString(1, r.getName());
            stmt.setString(2, r.getEmail());
            stmt.setString(3, r.getPassword());
            stmt.setString(4, r.getRole());
            stmt.executeUpdate();
            
        }
}