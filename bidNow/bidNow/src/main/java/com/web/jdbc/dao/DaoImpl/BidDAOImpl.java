package com.web.jdbc.dao.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.web.jdbc.dao.BidDAO;
import com.web.jdbc.model.Bid;
import com.web.jdbc.model.Customer;
import com.web.jdbc.model.Item;

@Repository
public   class BidDAOImpl implements BidDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }



	public List<Bid> MaxBid() {
		String sql = "SELECT m.`bid_no`,i.`name`,cus.`customer_name`,m.`price`" + 
				"FROM `Item` i,`customer` cus,`bidCustomer` m   " + 
				"    LEFT JOIN bidCustomer b    " + 
				"        ON m.`prod_id` = b.`prod_id`" + 
				"        AND m.`price` < b.`price`" + 
				"WHERE b.`price` IS NULL AND m.`customer_id`=cus.`c_id` AND m.`prod_id`=i.`prod_id`";

		List<Bid> List = jdbcTemplate.query(sql, new ResultSetExtractor<List<Bid>>() {
			public List<Bid> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bid> list = new ArrayList<Bid>();
				while (rs.next()) {
					Bid bd=new 	Bid();
					bd.setBidNo(rs.getString(1));
					bd.setProd_name(rs.getString(2));
					bd.setCustomer_name(rs.getString(3));
					bd.setPrice(rs.getString(4));
					list.add(bd);
				}
				return list;
			}

		});
		return List;
	}



	public List<Bid> MaxBidSearchName() {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}
