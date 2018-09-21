package com.web.jdbc.dao;

import java.util.List;

import com.web.jdbc.model.*;

public interface BidDAO {
	
	List<Bid> MaxBid();
	
	List<Bid> MaxBidSearchName();
	
	
	
}
