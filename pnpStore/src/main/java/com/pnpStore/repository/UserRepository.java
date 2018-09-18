package com.pnpStore.repository;

//import UserRepository used files
import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.pnpStore.model.User;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository("userRepository")

//JpaRepository - uses CRUD(Create,Read,Update and Delete) functionalities and other Repository functionalities
//Interfaces - collection of abstract classes
public interface UserRepository extends JpaRepository<User, Long> {
	
	//fetches customer with a specific email 
	 User findByEmail(String email);

	User findUserBylastName(String lastName);
}
