package com.pnpStore.service;

//import UserService used files
import com.pnpStore.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public void saveAdmin(User user);
	public void saveDriver(User user);
	public void saveSupplier(User user);
	public User findUserBylastName(String lastName);
}



