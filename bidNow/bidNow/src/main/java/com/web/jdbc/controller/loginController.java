package com.web.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.jdbc.model.Customer;
import com.web.jdbc.model.User;
import com.web.jdbc.service.BidService;
import com.web.jdbc.service.loginService;

@Controller

@RequestMapping("/login")
public class loginController {

	@Autowired
	private loginService loginService;
	
	@Autowired 
	private BidService bdServ;

	
	@RequestMapping(value = "/LoginNow")
	public ModelAndView LoginVerify(@RequestParam("username") String username,
			@RequestParam("password") String password,RedirectAttributes redirectAttributes) {

		User usr = new User();
		usr.setUsername(username);
		usr.setPassword(password);

		System.out.println("inside login method");
		String type = loginService.LoginVerify(usr);

		if (type.equalsIgnoreCase("admin")) {
			ModelAndView mv = new ModelAndView("adminPortal");
			//mv.addObject("bookList", bookService.getAllbooks());
			return mv;

		} else if (type.equalsIgnoreCase("customer")) {
			
			 ModelAndView mv=new ModelAndView("redirect:/Customer/list");
			 redirectAttributes.addAttribute("username", username);
			   
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView("login");
			return mv;
		}
	}
	@RequestMapping(value = "/RegisterNew")
	public ModelAndView RegisterNewCustomer(@RequestParam("namee") String namee,
			@RequestParam("address") String address,
			@RequestParam("username1") String username1,
			@RequestParam("password2") String password2) 
	{
		User usr = new User();
		usr.setUsername(username1);
		usr.setPassword(password2);
		
		Customer cus=new Customer();
		cus.setCustomerName(namee);
		cus.setCustomerAddress(address);

		loginService.RegisterUser(usr, cus);
		System.out.println("indisde register method");
			
		ModelAndView mv=new ModelAndView("login");
			return mv;
	}
}

