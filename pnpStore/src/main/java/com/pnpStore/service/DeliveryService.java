package com.pnpStore.service;

//import DeliveryService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Delivery;
import com.pnpStore.repository.DeliveryRepository;


//@Services - creates a services bean , has all business logic and calls methods from DeliveryRepository
@Service
public class DeliveryService {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	public DeliveryRepository deliveryRepository;
	//gets All deliveries
	public List<Delivery> getAlldeliveries()
	{
		
		List<Delivery> deliveries = new ArrayList<>();
		deliveryRepository.findAll()
		.forEach(deliveries::add);
		return deliveries;
		
	}
	
	//Delete Delivery using delivery id 
	public void DeleteDelivery(int deliveryID) {
		
		
		deliveryRepository.delete(deliveryID);
		
	}
	
	//Add Delivery
	public void SaveDelivery(Delivery Deliveries) {
		
		
		deliveryRepository.save(Deliveries);
		
	}
	
	//Update Delivery using delivery id 
	public void updateDelivery(int id, Delivery Deliveries) {
		
		
		deliveryRepository.save(Deliveries);
		
	}
	

}
