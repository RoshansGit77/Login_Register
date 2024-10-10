package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DBUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean isValidUser(String username, String password) {
		String query = "select * from users where username=? and password=?";
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, username);
			ps.setString(2, password);
			System.out.println("query run ho gai");
			ResultSet rs = ps.executeQuery();
			
			return rs.next();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(User user) {
		String query = "insert into users (username, email, password) values(?,?,?)";
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			int rows = ps.executeUpdate();
			System.out.println("user added successfully");
			return rows>0;
		
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	}

}
