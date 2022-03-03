package com.training.pms.dao;

import com.training.pms.model.Accounts;
import com.training.pms.model.Login;

public interface LoginDAO {
	public boolean register(Login login, Accounts account);
	public boolean validate(String username,String password);
	public boolean validate(int loginId, String username,String password);
	public boolean isAccountExists(String username);
}
