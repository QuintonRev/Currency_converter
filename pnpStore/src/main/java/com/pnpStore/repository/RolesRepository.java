package com.pnpStore.repository;

//import RolesRepository used files
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.Role;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository("rolesRepository")
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface RolesRepository extends CrudRepository <Role, Integer> {
	//fetches customer with a specific role
	Role findByRole(String role);	

}
