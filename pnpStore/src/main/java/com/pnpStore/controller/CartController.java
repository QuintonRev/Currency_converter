package com.pnpStore.controller;

//import CartController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnpStore.model.Cart;
import com.pnpStore.service.CartService;


//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class CartController {

	
	
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private CartService cartService;
	
	//RequestMapping - maps the specified URL eg '/SaveCart'
	//RequestMethod = request method type - POST it inserts specific resources
	@RequestMapping(method = RequestMethod.POST,value = "/SaveCart")
	//@RequestBody converts JSON format to java object
	public void SaveCart(@RequestBody Cart Carts)
	{
		cartService.SaveCart(Carts);		

	}
	//RequestMapping - maps the specified URL eg '/DeleteCart/{cartID}'
	//RequestMethod = request method type - DELETE it removes specific resources using a certain ID
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteCart/{cartID}")
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteCart(@PathVariable int cartID)
	{
		cartService.DeleteCart(cartID);

	}
	
	//RequestMapping - maps the specified URL eg '/UpdateCart/{userID}'
	//RequestMethod = request method type - PUT it updates specific resources using a certain ID
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateCart/{userID}")
	//@RequestBody converts JSON format to java object
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void updateCart(@RequestBody Cart carts, @PathVariable int userID)
	{
		
		cartService.updateCart(userID, carts);
		
	}
	//RequestMapping - maps the specified URL eg '/GetCarts'
	@RequestMapping("/GetCarts")
	//Generic array list
	public List<Cart> getAllCarts() 
	{
		return cartService.getAllCarts();
	}
	
	
}
