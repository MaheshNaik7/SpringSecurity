package com.Springbootsecurity.FormAuthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	//Form Authentication(provides default -> Login and Logout page and logout url)
	//Securing REST API's through basic authentication
	
	@GetMapping({"/hellouser"})
	public String helloUser(){
		return "Hello User";
	}
	
	@GetMapping({"/helloadmin"})
	public String helloAdmin(){
		return "Hello Admin";
	}

}