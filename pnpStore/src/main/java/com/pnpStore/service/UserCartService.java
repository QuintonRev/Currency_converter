package com.pnpStore.service;

//import UserCartService used files
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.User;
import com.pnpStore.repository.CartUserRepository;


//@Services - creates a services bean , has all business logic and calls methods from CartUserRepository
@Service
public class UserCartService {
	
	

	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
	private CartUserRepository userCartRepository;
//gets user by email	
public ArrayList<User> getUser(String email)
	{
		return userCartRepository.viewByUserId(email);
	}

}
