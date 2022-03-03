package com.training.pms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.training.pms.model.Accounts;
import com.training.pms.utility.DBConnection;

//CODE - DB
public class AccountsDAOImpl implements AccountsDAO {

	Connection con = DBConnection.getConnection();

	@Override
	public Accounts viewBalance(String username) {
		Accounts account = new Accounts();
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from accounts where name = ?");
			stat.setString(1, username);

			ResultSet res = stat.executeQuery();
			res.next();
			account.setAccountId(res.getInt(1));
			account.setName(res.getString(2));
			account.setBalance(res.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public int deposit(int currentBalance, int deposit, String username) {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement
					("update accounts set balance = balance + ? where name = ?");
			stat.setInt(1, deposit);
			stat.setString(2, username);

			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentBalance;
	}
	
	@Override
	public int withdraw(int currentBalance, int withdraw, String username) {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement
					("update accounts set balance = balance - ? where name = ?");
			stat.setInt(1, withdraw);
			stat.setString(2, username);

			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentBalance;
	}


	@Override
	public int transferAmountAndGetbalance(int sender, int receiver, int amount, int debitorBalance, int creditorBalance) {
		CallableStatement stat;
		try {
			stat = con.prepareCall("call transferAmountAndGetbalance(?,?,?,?,?)");
			stat.setInt(1, sender);
			stat.setInt(2, receiver);
			stat.setInt(3, amount);
			
			stat.registerOutParameter(4, Types.INTEGER);
			stat.setInt(4, debitorBalance);

			stat.registerOutParameter(5, Types.INTEGER);
			stat.setInt(5, creditorBalance);
			
			stat.execute();
			
			debitorBalance = stat.getInt(4);
			creditorBalance = stat.getInt(5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return debitorBalance;

	}


}
