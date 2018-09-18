package com.pnpStore.controller;

//import RoleController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnpStore.model.Role;
import com.pnpStore.service.RoleService;

//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class RoleController {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private RoleService rolesService;
	
	//RequestMapping - maps the specified URL eg '/GetRoles'
	@RequestMapping("/GetRoles")
	//Generic array list
	public List<Role> getAllRoles() 
	{
		return rolesService.getAllRoles();
	}	
	
}
