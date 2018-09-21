package com.web.jdbc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.jdbc.dao.DaoImpl.ItemDAOImpl;
import com.web.jdbc.model.Item;
import com.web.jdbc.service.itemService;

@Service
public class itemServiceImpl implements itemService{

	@Autowired
	private ItemDAOImpl itemDAO;

	public void CreateItem(Item itm,String glu) {
		itemDAO.CreateItem(itm,glu);
		
	}
}
