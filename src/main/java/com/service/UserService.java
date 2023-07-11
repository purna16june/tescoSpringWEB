package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	public void addUser(User user);
	
	public List<User> loadUser();
	
	public boolean loginUser(String uname, String pass);
	
	public boolean findUser(String uname);
	
	public boolean removeUser(String uname);
	
	public void updateUser(String uname, User user);
}
