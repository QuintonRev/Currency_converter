package com.pnpStore.controller;

//import OrderController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pnpStore.model.Order;
import com.pnpStore.service.OrderService;

//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class OrderController {

	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private OrderService orderService;
	
	//RequestMapping - maps the specified URL eg '/GetOrders'
	@RequestMapping("/GetOrders")
	//Generic array list
	public List<Order> getAllOrders() 
	{
		return orderService.getAllOrders();
	}
	
	
	
	
	//RequestMapping - maps the specified URL eg '/InsertOrders'
		//RequestMethod = request method type - POST it inserts specific resources
	@RequestMapping(method = RequestMethod.POST,value = "/InsertOrders")
	//@RequestBody converts JSON format to java object
	public void AddOrder(@RequestBody Order Orders)
	{
		
		orderService.AddOrder(Orders);
		
	}
	
	//RequestMapping - maps the specified URL eg '/UpdateOrder/{id}'
		//RequestMethod = request method type - PUT it updates specific resources using a certain ID
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateOrder/{id}")
	//@RequestBody converts JSON format to java object
		//@PathVariable - identifies the path pattern used in URL for incoming data
	public void updateOrder(@RequestBody Order Orders, @PathVariable int id)
	{
		
		orderService.updateOrder(id, Orders);
		
	}
	
	//RequestMapping - maps the specified URL eg '/DeleteOrder/{orderID}'
		//RequestMethod = request method type - DELETE it removes specific resources using a certain ID
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteOrder/{orderID}")
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteOrder( @PathVariable int orderID)
	{
		orderService.DeleteOrder(orderID);

	}

	

	}
