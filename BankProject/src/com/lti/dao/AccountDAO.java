package com.lti.dao;

import java.util.List;
import com.lti.bean.Account;

public interface AccountDAO 
{
	public boolean insertAccount(Account ob);
	public boolean updateAccount(Account ob);
	public boolean deleteAccount(Account ob);
	
	public Account getAccountById(int aid);
	public List<Account> getAllAccount();
}
