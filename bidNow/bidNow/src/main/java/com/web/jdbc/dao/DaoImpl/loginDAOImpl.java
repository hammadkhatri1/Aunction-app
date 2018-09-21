package com.web.jdbc.dao.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.jdbc.dao.loginDAO;
import com.web.jdbc.model.Customer;
import com.web.jdbc.model.User;

@Repository
public class loginDAOImpl implements loginDAO{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

	public String LoginVerify(User usr) {
		try {
			String sql = "select type from user where username=? and password= ?";
	        String type = (String) jdbcTemplate.queryForObject(sql, new Object[]
	        {usr.getUsername(), usr.getPassword()}, String.class);
	        	        
				return type;
			}
			catch(EmptyResultDataAccessException e) {
				String resulttype = "wrong";
				return resulttype;
			}
	        
	}

	public void RegisterUser(User usr, Customer cust) {
		
		String sql1 = "insert into user (username,password,type) values(?,?,?)";
		System.out.println("new user dao called \n sql1");
		jdbcTemplate.update(sql1,
				new Object[] { usr.getUsername(), usr.getPassword(),"customer"});

		//getting new users id
		System.out.println("sql2");
		String sql2 = "select userId from user where username=? and password= ?";
        String Userid= (String) jdbcTemplate.queryForObject(sql2, new Object[]
        {usr.getUsername(), usr.getPassword()}, String.class);
        
		String sql3 = "insert into customer (customer_name,customer_address,user_id) values(?,?,?)";
		System.out.println("sql3");
		jdbcTemplate.update(sql3,
				new Object[] { cust.getCustomerName(), cust.getCustomerAddress(),Userid});

	}
	
	}


