package com.pnpStore.service;

//import RoleService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pnpStore.model.Role;
import com.pnpStore.repository.RolesRepository;

//@Services - creates a services bean , has all business logic and calls methods from RolesRepository
@Service
public class RoleService {
	
	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
	public RolesRepository rolesRepository;

	public List<Role> getAllRoles()
	{
		
		List<Role> Roles = new ArrayList<>();
		rolesRepository.findAll()
		.forEach(Roles::add);
		return Roles;
		
	}

}
