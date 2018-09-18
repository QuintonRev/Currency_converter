package com.pnpStore.repository;

//import DeliveryRepository used files
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.Delivery;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface DeliveryRepository extends CrudRepository <Delivery, Integer>
 {
	// @Query - Used when I want to generate my own query
    @Query("SELECT l FROM Delivery l WHERE l.delivery_id = :delivery_id")
  //@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<Delivery> viewByProductId(@Param("delivery_id") int delivery_id);

}
