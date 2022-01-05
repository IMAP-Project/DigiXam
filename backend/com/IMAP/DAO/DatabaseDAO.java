package com.IMAP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.IMAP.model.User;

public class DatabaseDAO {
	DbConnection dbcon;
	Connection con;
	
	public DatabaseDAO() throws SQLException {
		super();
		dbcon= new DbConnection();
		con= dbcon.getConnection();
	}
	
	public void registration(User u) throws SQLException
	{
		String sql= "INSERT INTO users (name,email,username,password) VALUES (?,?,?,md5(?))";
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, u.getName());
		st.setString(2, u.getEmail());
		st.setString(3, u.getUsername());
		st.setString(4, u.getPassword());
		int i= st.executeUpdate();
		System.out.println(i+" row inserted succecfully.");
		
	}
	public boolean login(User u) throws SQLException
	{
		String sql="SELECT * FROM users WHERE email=? OR username=? AND password=md5(?)";
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, u.getEmail());
		st.setString(2, u.getUsername());
		st.setString(3, u.getPassword());
		ResultSet rs= st.executeQuery();
		if(rs.next())
			return true;
		else 
			return false;
	}
}
