package com.web.jdbc.dao.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.jdbc.dao.ItemDAO;
import com.web.jdbc.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public void CreateItem(Item itm,String glu) {
		String sql1 = "insert into Item (name,price,description) values(?,?,?)";
		System.out.println("step 1");
		jdbcTemplate.update(sql1,
				new Object[] { itm.getName(), itm.getPrice(),itm.getDescription()});

		//getting new prod id
				System.out.println("step 2");
				String sql2 = "select prod_id from Item where name=? and description= ?";
		        String proddId= (String) jdbcTemplate.queryForObject(sql2, new Object[]
		        {itm.getName(),itm.getDescription()}, String.class);
		        
		        ///geting userrid
		        System.out.println("step 3");
				String sql3 = "select c_id from customer where customer_name=?";
		        String customerId= (String) jdbcTemplate.queryForObject(sql3, new Object[]
		        {glu}, String.class);
		        
		       
				String sql4 = "insert into bidCustomer (prod_id,customer_id,price) values(?,?,?)";
				System.out.println("new item dao called \n sql1");
				jdbcTemplate.update(sql4,
						new Object[] { proddId, customerId,itm.getPrice()});
				System.out.println("step 4 one all");
		        

	}

}
