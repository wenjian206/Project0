package com.training.pms.dao;

import com.training.pms.model.Employee;

public interface EmployeeDAO {
	public Employee searchAccountById(int accountId);

	public Employee searchAccountByName(String name);
	
	public boolean isAccountExists(int accountId);
	
	public boolean isAccountExists(String name);
}
