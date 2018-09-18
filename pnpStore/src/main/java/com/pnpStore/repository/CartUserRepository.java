package com.pnpStore.repository;

//import CartUserRepository used files
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.User;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface CartUserRepository  extends CrudRepository <User, Integer> {

	// @Query - Used when I want to generate my own query
	@Query("SELECT u FROM User u WHERE u.email = :email")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<User> viewByUserId(@Param("email") String email);
	

}
