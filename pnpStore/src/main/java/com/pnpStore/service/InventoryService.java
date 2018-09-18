package com.pnpStore.service;

//import InventoryService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Inventory;
import com.pnpStore.repository.InventoryRepository;


//@Services - creates a services bean , has all business logic and calls methods from InventoryRepository
@Service
public class InventoryService {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	public InventoryRepository inventoryRepository;
	
	//gets All inventories
	public List<Inventory> getAllinventories()
	{
		
		List<Inventory> inventories = new ArrayList<>();
		inventoryRepository.findAll()
		.forEach(inventories::add);
		return inventories;
		
	}
	
	//Delete user Inventory inventory id 
	public void DeleteInventory(int inventoryID) {
		
		
		inventoryRepository.delete(inventoryID);
		
	}
	
	//Add Inventory 
	public void SaveInventory(Inventory Inventories) {
		
		
		inventoryRepository.save(Inventories);
		
	}
	
	//Update Inventory using inventory id 
	public void updateInventory(int id, Inventory Inventories) {
		
		
		inventoryRepository.save(Inventories);
		
	}
	

}