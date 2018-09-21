package com.web.jdbc.dao;

import com.web.jdbc.model.Customer;
import com.web.jdbc.model.User;

public interface loginDAO {

	String LoginVerify(User usr);
	void RegisterUser(User usr,Customer cust);
	
}
