package com.web.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.jdbc.model.Bid;
import com.web.jdbc.model.Customer;
import com.web.jdbc.model.Item;
import com.web.jdbc.service.BidService;
import com.web.jdbc.service.itemService;

@Controller

@RequestMapping("/Customer")
public class customerController {
	
	private String glUsername=null;

	@Autowired
	private BidService bidS ;
	
	@Autowired 
	private itemService IS;
	
	@RequestMapping(value = "/Search")
	public ModelAndView SearchbyName(@RequestParam("searchName") String searchName) {
		
	System.out.println("inside search");	
	ModelAndView model = new ModelAndView("customerPortal");

	
    List<Bid> bidList = bidS.MaxBidSearchName();
    System.out.println(bidList);
    model.addObject("bidList",bidList);
    
    return model;
	}
	
	@RequestMapping(value = "/SubmitItem")
	public void submitItem(@RequestParam("namee") String namee,
			@RequestParam("startingPrice") String startingPrice,
			@RequestParam("description") String description) {
		
	System.out.println("inside submssitItem");	
	
	Item it=new Item();
	it.setName(namee);
	it.setDescription(description);
	it.setPrice(startingPrice);
	
	IS.CreateItem(it,glUsername);
	
	listbook(glUsername);
	}
	
	@RequestMapping(value = "/list")
    public ModelAndView listbook(@RequestParam("username") String username)
    {
		System.out.println(username);
		glUsername=username;
        ModelAndView model = new ModelAndView("customerPortal");

        List<Bid> bidList = bidS.MaxBid();
        System.out.println(bidList);
        model.addObject("bidList",bidList);
        model.addObject("USERNAME1",username);
        
        return model;
    }
	@RequestMapping(value = "bidOnItem")
	public ModelAndView BidOnItem(@RequestParam("bid_id") String namee,
			@RequestParam("startingPrice") String startingPrice,
			@RequestParam("description") String description) {
		
	System.out.println("inside submitItem");	
	return null;
	}
	
}
