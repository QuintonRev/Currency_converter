package com.pnpStore.repository;

//import InventoryRepository used files
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.Inventory;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface InventoryRepository extends CrudRepository <Inventory, Integer>
 {
	// @Query - Used when I want to generate my own query
    @Query("SELECT l FROM Inventory l WHERE l.inventory_id = :inventory_id")
  //@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<Inventory> viewByinventoryId(@Param("inventory_id") int inventory_id);

}