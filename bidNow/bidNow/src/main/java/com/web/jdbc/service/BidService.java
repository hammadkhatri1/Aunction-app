package com.web.jdbc.service;

import java.util.List;

import com.web.jdbc.model.Bid;
import com.web.jdbc.model.Customer;
import com.web.jdbc.model.Item;

public interface BidService {

	List<Bid> MaxBid();
	List<Bid> MaxBidSearchName();
	
	
}
