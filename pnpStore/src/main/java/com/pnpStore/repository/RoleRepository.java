package com.pnpStore.repository;

//import RoleRepository used files
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.pnpStore.model.Role;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository("roleRepository")
//JpaRepository - uses CRUD(Create,Read,Update and Delete) functionalities and other Repository functionalities
//Interfaces - collection of abstract classes
public interface RoleRepository extends JpaRepository<Role, Integer>{
	//fetches customer with a specific role
	Role findByRole(String role);

}
