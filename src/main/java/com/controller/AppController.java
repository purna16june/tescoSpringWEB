package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

//@Controller
@RestController
@RequestMapping("/mainapp")
public class AppController {

	List<User> userList = new ArrayList<User>();
	// UserService userService= new UserServiceImpl ();

	@Autowired
	private UserService userService;

	// Basic Way
	/*
	 * @RequestMapping(path="/loginPage",method=RequestMethod.POST)
	 * 
	 * @ResponseBody public String loginUser(@RequestParam("uname")String
	 * uname,@RequestParam("pass")String pass ) {
	 * if(uname.equals("admin")&&pass.equals("manager")) { return "Login Sucess"; }
	 * return "Login Failure"; }
	 */

	// Simple way
	@PostMapping("/loginPage")
	// @RequestMapping(path="/loginPage",method=RequestMethod.POST)
	// @ResponseBody
	public String loginUser(@ModelAttribute User users) {
		if (userService.loginUser(users.getUname(), users.getPass())) {
			return "Login Sucess";
		}
		return "Login Failure";
	}

	/*
	 * @RequestMapping(path="/registrationPage",method=RequestMethod.POST)
	 * 
	 * @ResponseBody public String loadRegistrationPage(@RequestParam("uname")String
	 * uname,@RequestParam("pass")String pass,@RequestParam("mail")String
	 * mail,@RequestParam("ucity") String ucity ) { userService.addUser(uname, pass,
	 * mail, ucity); return userService.loadUser().toString(); //return
	 * "Sucessfully registered"; }
	 */

	@PostMapping("/registrationPage")
	// @RequestMapping(path="/registrationPage",method=RequestMethod.POST)
	// @ResponseBody
	public String loadRegistrationPage(@ModelAttribute User users) {
		//userService.addUser(users);
		 userService.loadUser().toString();
		return  "Sucessfully registered";
	}
	
	@GetMapping("/loadall")
	public List<User> retriveUsers(){
		return userService.loadUser();
	}
	
	@GetMapping("/finduser/{uname}")
	public String findUser(@PathVariable String uname) {
		if(userService.findUser(uname)) {
			return uname +"found..!";
		}
		return "user not found";
	}
	
	@DeleteMapping("/deleteuser/{uname}")
	public String deleteUser(@PathVariable String uname) {
		if(userService.removeUser(uname)) {
			return uname +"removed";
		}
		return "user not found";
	}
	
	@PutMapping("/updateuser/{uname}")
	public String updateUser(@PathVariable String uname, @RequestBody User user) {
		
		userService.updateUser(uname, user);
		
		return uname+" updated";
	}

}
