package com.web.jdbc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.jdbc.dao.DaoImpl.loginDAOImpl;
import com.web.jdbc.model.Customer;
import com.web.jdbc.model.User;
import com.web.jdbc.service.loginService;

@Service
public class LoginServiceImpl implements loginService {


	@Autowired
	private loginDAOImpl loginDAO;
	
	public String LoginVerify(User usr) {
		return	loginDAO.LoginVerify(usr);

	}
	public void RegisterUser(User usr, Customer cust) {
		
		loginDAO.RegisterUser(usr, cust);
		
	}
}
