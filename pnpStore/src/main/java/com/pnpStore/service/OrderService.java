package com.pnpStore.service;

//import OrderService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Order;
import com.pnpStore.repository.OrderRepository;

//@Services - creates a services bean , has all business logic and calls methods from OrderRepository
@Service
public class OrderService {

	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	public OrderRepository orderRepository;
	
	//gets All Orders
	public List<Order> getAllOrders()
	{
		
		List<Order> Orders = new ArrayList<>();
		orderRepository.findAll()
		.forEach(Orders::add);
		return Orders;
		
	}
	
	//Add Order 
	public void AddOrder(Order Orders) {
		
		orderRepository.save(Orders);
		
	}
	
	//Update Order using order id 
	public void updateOrder(int id, Order Orders) 
	{

		orderRepository.save(Orders);
	}


	//Delete Order using order id 
	public void DeleteOrder(int orderID) {
		
		
		orderRepository.delete(orderID);
		
	}
	
	
}
