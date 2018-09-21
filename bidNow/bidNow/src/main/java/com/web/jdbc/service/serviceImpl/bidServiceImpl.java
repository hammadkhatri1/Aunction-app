package com.web.jdbc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.jdbc.dao.DaoImpl.BidDAOImpl;
import com.web.jdbc.dao.DaoImpl.ItemDAOImpl;
import com.web.jdbc.dao.DaoImpl.loginDAOImpl;
import com.web.jdbc.model.Bid;
import com.web.jdbc.model.Customer;
import com.web.jdbc.model.Item;
import com.web.jdbc.service.BidService;

@Service
public class bidServiceImpl implements BidService{

	@Autowired
	private BidDAOImpl bidDAO;

	

	public List<Bid> MaxBid() {
		// TODO Auto-generated method stub
		return bidDAO.MaxBid();
	}



	public List<Bid> MaxBidSearchName() {
		// TODO Auto-generated method stub
		return bidDAO.MaxBidSearchName();
	}

	
	
}
