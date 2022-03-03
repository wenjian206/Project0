package com.training.pms.dao;

import com.training.pms.model.Accounts;


public interface AccountsDAO {
	public Accounts viewBalance(String username);
	public int deposit(int currentBalance, int deposit, String username);
	public int withdraw(int currentBalance, int withdraw, String username);
	public int transferAmountAndGetbalance(int sender, int receiver, int balance, int debitorBalance, int creditorBalance);
}