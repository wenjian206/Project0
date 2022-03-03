package com.training.pms.model;

import java.util.Objects;

public class Employee {
	private int accountId;
	private String name;
	private int balance;
	
	public Employee() {
		
	}

	public Employee(int accountId, String name, int balance) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.balance = balance;
	}



	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, balance, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return accountId == other.accountId && balance == other.balance && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [accountId=" + accountId + ", name=" + name + ", balance=" + balance + "]";
	}

	
}