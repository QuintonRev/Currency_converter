package com.pnpStore.service;

//import UsersService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.User;
import com.pnpStore.repository.UsersRepository;

//@Services - creates a services bean , has all business logic and calls methods from UsersRepository
@Service
public class UsersService {

	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
	public UsersRepository usersRepository;
	
	//gets All Users 	
	public List<User> getAllUsers()
	{
		
		List<User> Users = new ArrayList<>();
		usersRepository.findAll()
		.forEach(Users::add);
		return Users;
		
	}
	
	//Add user 
	public void AddUser(User Users) {
		
		usersRepository.save(Users);
		
	}
	
	//Update user using user id 
	public void updateUser(int id, User Users) 
	{

		usersRepository.save(Users);
	}

	//Delete user using user id 
    public void DeleteUser(int userID) {
		
		
    	usersRepository.delete(userID);
		
	}
	
	
}
