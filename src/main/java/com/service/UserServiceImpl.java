package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;



@Service
public class UserServiceImpl implements UserService{

	
	public List<User> userList = new ArrayList<User>();
	

	@Override
	public void addUser(User user) {
		
		userList.add(user);
		
	}

	@Override
	public List<User> loadUser() {
		
		return userList;
	}

	@Override
	public boolean loginUser(String uname, String pass) {
		if(uname.equals("admin")&& pass.equals("manager")) {
		return true;
		}
		return false;
		
	}

	@Override
	public boolean findUser(String uname) {
		for(User usr:userList) {
			if(usr.getUname().equals(uname)) {
				return true;
			}
			
		}
		return false;
	}

	@Override
	public boolean removeUser(String uname) {
		for(User usr:userList) {
			if(usr.getUname().equals(uname)) {
				userList.remove(usr);
				return true;
			}
			
		}
		return false;
	}

	@Override
	public void updateUser(String uname, User user) {
		if(user.getUname().equals(uname)) {
			user.setMail(user.getMail());
			user.setUname(user.getUname());
			user.setPass(user.getPass());
			user.setUcity(user.getUcity());
		}
		
	}

}
