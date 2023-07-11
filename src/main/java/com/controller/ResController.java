package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mainapp")
public class ResController {
	
	//@RequestMapping(path="/loginPage",method=RequestMethod.GET)
	@GetMapping("/loginPage")
	public String loadLoginPage() {
		//return should be your html page name
		return "login";
	}
	
	//@RequestMapping(path="/registrationPage",method=RequestMethod.GET)
	@GetMapping("/registrationPage")
	public String loadRegistrationPage() {
		//return should be your html page name
		return "register";
	}
	
	

}
