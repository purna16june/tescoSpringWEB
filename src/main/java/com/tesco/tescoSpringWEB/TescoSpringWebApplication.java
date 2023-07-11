package com.tesco.tescoSpringWEB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.service.UserService;

@SpringBootApplication
@ComponentScan("com")
public class TescoSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TescoSpringWebApplication.class, args); 
	}

}
