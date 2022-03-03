package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.pms.model.Employee;
import com.training.pms.utility.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con = DBConnection.getConnection();
	
	@Override
	public Employee searchAccountById(int accountId) {
		System.out.println("Search account with account Id: "+accountId);
		Employee employee = new Employee();
		PreparedStatement stat;
    	try {
			stat = con.prepareStatement("select * from accounts where accountId = ? ");
			stat.setInt(1, accountId);

			ResultSet res = stat.executeQuery();
			res.next();
			employee.setAccountId(res.getInt(1));
			employee.setName(res.getString(2));
			employee.setBalance(res.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
	@Override
		public Employee searchAccountByName(String name) {
			System.out.println("Search account with owner's name: "+ name);
			Employee employee = new Employee();
			PreparedStatement stat;
	    	try {
				stat = con.prepareStatement("select * from accounts where name = ? ");
				stat.setString(1, name);

				ResultSet res = stat.executeQuery();
				res.next();
				employee.setAccountId(res.getInt(1));
				employee.setName(res.getString(2));
				employee.setBalance(res.getInt(3));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return employee;
		}
	
	@Override
	public boolean isAccountExists(int accountId) {
		boolean accountExists = false;
		PreparedStatement stat;
    	try {
    		stat = con.prepareStatement("select * from accounts where accountId = ? ");
        	stat.setInt(1, accountId);
    		
        	ResultSet res = stat.executeQuery();
        	accountExists = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountExists;
	}
	
	@Override
	public boolean isAccountExists(String name) {
		boolean accountExists = false;
		PreparedStatement stat;
    	try {
    		stat = con.prepareStatement("select * from accounts where name = ? ");
        	stat.setString(1, name);
    		
        	ResultSet res = stat.executeQuery();
        	accountExists = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountExists;
	}
}
