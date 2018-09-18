package com.pnpStore.controller;

//import UserCartController used files
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pnpStore.model.Cart;
import com.pnpStore.model.User;
import com.pnpStore.service.CartService;
import com.pnpStore.service.UserCartService;

//@Controller - indicates that it is a  Spring MVC controller 
@Controller
public class UserCartController {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private UserCartService userCartService ;
	private String userMail ;
	
	//RequestMapping - maps the specified URL eg '/user'
	//RequestMethod = request method type - GET it requests specific resources
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	//@ResponseBody - converts Java objects to JSON objects
    @ResponseBody
    public String currentUserName(Authentication authentication) {

    
		userMail = authentication.getName();
		return userMail;
    		
    }
	//RequestMapping - maps the specified URL eg '/viewUser'
	//RequestMethod = request method type - GET it requests specific resources
	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	//@ResponseBody - converts Java objects to JSON objects
	@ResponseBody
	//Generic array list
	public ArrayList<User> getUser(String email)

	{
		ArrayList<User> Cart = userCartService.getUser(userMail);
	 
	return Cart;
  
	}
	
  
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private CartService cartService;
	
	//RequestMapping - maps the specified URL eg '/viewCart/{user_id}'
		//RequestMethod = request method type - GET it requests specific resources	
@RequestMapping(value = "/viewCart/{user_id}", method = RequestMethod.GET)
//@ResponseBody - converts Java objects to JSON objects
	@ResponseBody
	//Generic array list
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public ArrayList<Cart> getAllCart(@PathVariable int user_id)
	{
		ArrayList<Cart> Cart = cartService.getCart(user_id);
	 
	return Cart;
	}
	

}
