package com.web.jdbc.service;

import com.web.jdbc.model.Customer;
import com.web.jdbc.model.User;

public interface loginService {
	
	void RegisterUser(User usr,Customer cust);
	
	String LoginVerify(User usr);
}
