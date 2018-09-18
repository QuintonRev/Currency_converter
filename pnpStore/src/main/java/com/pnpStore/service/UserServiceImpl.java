package com.pnpStore.service;

//import UserServiceImpl used files
import java.util.Arrays;

import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Role;
import com.pnpStore.model.User;
import com.pnpStore.repository.RoleRepository;
import com.pnpStore.repository.UserRepository;

//@Services - creates a services bean , has all business logic and calls methods from UserRepository and RoleRepository and BCryptPasswordEncoder 
@Service("userService")
//Acts as implementation class to abstract class UserService
public class UserServiceImpl implements UserService{
	
	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
	private UserRepository userRepository;
	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
    private RoleRepository roleRepository;
	//@Autowired - uses properties to get rid of setter methods 
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    //@override - used for every method intended as an implementation of an interface(UserService).
    //First, it catches misspellings like " hashcode() " instead of " hashCode() " at compile-time
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	//@override - used for every method intended as an implementation of an interface(UserService).
    //First, it catches misspellings like " hashcode() " instead of " hashCode() " at compile-time
	@Override
	public void saveUser(User user) {
		//Encrypts password as the user is being saved
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        //gets user role
        Role userRole = roleRepository.findByRole("CLIENT");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
		
	
	}
	
	@Override
	public void saveAdmin(User user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    Role userRole = roleRepository.findByRole("ADMIN");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	userRepository.save(user);
}

	@Override
	public void saveDriver(User user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    Role userRole = roleRepository.findByRole("DRIVER");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	userRepository.save(user);
}
	
	@Override
public void saveSupplier(User user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    Role userRole = roleRepository.findByRole("SUPPLIER");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	userRepository.save(user);
}

	@Override
	public User findUserBylastName(String lastName) {
		// TODO Auto-generated method stub
		return userRepository.findUserBylastName(lastName);
	}
	


}
