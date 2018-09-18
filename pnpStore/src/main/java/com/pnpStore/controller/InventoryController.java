package com.pnpStore.controller;

//import InventoryController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnpStore.service.InventoryService;
import com.pnpStore.model.Inventory;

//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class InventoryController {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private InventoryService inventoryService;
	
	//RequestMapping - maps the specified URL eg '/GetInventories'
	@RequestMapping("/GetInventories")
	//Generic array list
	public List<Inventory> getAllinventories() 
	{
		return inventoryService.getAllinventories();
	}
	
	//RequestMapping - maps the specified URL eg '/DeleteInventory/{inventoryID}'
		//RequestMethod = request method type - DELETE it removes specific resources using a certain ID
@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteInventory/{inventoryID}")
//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteInventory(@PathVariable int inventoryID)
	{
		inventoryService.DeleteInventory(inventoryID);

	}

//RequestMapping - maps the specified URL eg '/SaveInventory'
	//RequestMethod = request method type - POST it inserts specific resources
@RequestMapping(method = RequestMethod.POST,value = "/SaveInventory")
//@RequestBody converts JSON format to java object
public void SaveInventory(@RequestBody Inventory Inventories)
{
	inventoryService.SaveInventory(Inventories);		

}

//RequestMapping - maps the specified URL eg '/UpdateInventory/{id}'
	//RequestMethod = request method type - PUT it updates specific resources using a certain ID
@RequestMapping(method = RequestMethod.PUT,value = "/UpdateInventory/{id}")
//@RequestBody converts JSON format to java object
	//@PathVariable - identifies the path pattern used in URL for incoming data
public void updateInventory(@RequestBody Inventory Inventories, @PathVariable int id)
{
	
	inventoryService.updateInventory(id, Inventories);
	
}
	

}