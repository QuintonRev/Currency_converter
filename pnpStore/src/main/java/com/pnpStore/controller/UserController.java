package com.pnpStore.controller;


//import UserController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnpStore.model.User;
import com.pnpStore.service.UsersService;


//@RestController - indicates that it is a  Spring MVC controller using REST API
@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private UsersService usersService;
	
	
	@CrossOrigin(origins = "*")
	//RequestMapping - maps the specified URL eg '/GetUsers'
	@RequestMapping("/GetUsers")
	//Generic array list
	public List<User> getAllUsers() 
	{
		return usersService.getAllUsers();
	}
	
	//RequestMapping - maps the specified URL eg '/InsertUsers'
	//RequestMethod = request method type - POST it inserts specific resources
	@RequestMapping(method = RequestMethod.POST,value = "/InsertUsers")
	//@RequestBody converts JSON format to java object
	public void AddUser(@RequestBody User Users)
	{
		
		usersService.AddUser(Users);
		
	}
	
	//RequestMapping - maps the specified URL eg '/UpdateUser/{id}'
	//RequestMethod = request method type - PUT it updates specific resources using a certain ID
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateUser/{id}")
	//@RequestBody converts JSON format to java object
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void updateUser(@RequestBody User Users, @PathVariable int id)
	{
		
		usersService.updateUser(id, Users);		
	}

	//RequestMapping - maps the specified URL eg '/DeleteUser/{userID}'
	//RequestMethod = request method type - DELETE it removes specific resources using a certain ID
    @RequestMapping(method = RequestMethod.DELETE,value = "/DeleteUser/{userID}")
  //@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteUser(@PathVariable int userID)
	{
		usersService.DeleteUser(userID);

	}
    
  
	
}


