package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.pms.model.Accounts;
import com.training.pms.model.Login;
import com.training.pms.utility.DBConnection;

//CODE - DB
public class LoginDAOImpl implements LoginDAO {

	Connection con = DBConnection.getConnection();

	@Override
	public boolean register(Login login, Accounts account) {
		System.out.println("Adding users: " + login);
		PreparedStatement statement = null;
		int rows1 = 0;
		int rows2 =0;
		try {
			statement = con.prepareStatement("insert into login values (default,?,?)");
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());
			rows1 = statement.executeUpdate();
			
			statement = con.prepareStatement("insert into accounts values (default,?,?)");
			statement.setString(1, login.getUsername());
			statement.setInt(2, account.getBalance());
			rows2 = statement.executeUpdate();
			
			System.out.println(rows1 + " user registered successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows1 == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from login where username = ? and password = ?");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}
	
	@Override
	public boolean validate(int loginId, String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from login where loginId = ? and username = ? and password = ?");
			stat.setInt(1,loginId);
			stat.setString(2, username);
			stat.setString(3, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}
	
	@Override
	public boolean isAccountExists(String username) {
		boolean accountExists = false;
		PreparedStatement stat;
    	try {
    		stat = con.prepareStatement("select * from login where username = ?");
        	stat.setString(1, username);
    		
        	ResultSet res = stat.executeQuery();
        	accountExists = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountExists;
	}


}
