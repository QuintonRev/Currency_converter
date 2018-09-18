package com.pnpStore.controller;

//import DeliveryController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnpStore.service.DeliveryService;
import com.pnpStore.model.Delivery;

//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class DeliveryController {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private DeliveryService deliveryService;
	
	//RequestMapping - maps the specified URL eg '/GetDeliveries'
	@RequestMapping("/GetDeliveries")
	//Generic array list
	public List<Delivery> getAlldeliveries() 
	{
		return deliveryService.getAlldeliveries();
	}
	
	//RequestMapping - maps the specified URL eg '/DeleteDelivery/{deliveryID}'
		//RequestMethod = request method type - DELETE it removes specific resources using a certain ID
@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteDelivery/{deliveryID}")
//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteDelivery(@PathVariable int deliveryID)
	{
		deliveryService.DeleteDelivery(deliveryID);

	}

//RequestMapping - maps the specified URL eg '/SaveDelivery'
	//RequestMethod = request method type - POST it inserts specific resources
@RequestMapping(method = RequestMethod.POST,value = "/SaveDelivery")
//@RequestBody converts JSON format to java object
public void SaveDelivery(@RequestBody Delivery Deliveries)
{
	deliveryService.SaveDelivery(Deliveries);		

}

//RequestMapping - maps the specified URL eg '/UpdateDelivery/{id}'
	//RequestMethod = request method type - PUT it updates specific resources using a certain ID
@RequestMapping(method = RequestMethod.PUT,value = "/UpdateDelivery/{id}")
//@RequestBody converts JSON format to java object
	//@PathVariable - identifies the path pattern used in URL for incoming data
public void updateDelivery(@RequestBody Delivery Deliveries, @PathVariable int id)
{
	
	deliveryService.updateDelivery(id, Deliveries);
	
}
	

}
