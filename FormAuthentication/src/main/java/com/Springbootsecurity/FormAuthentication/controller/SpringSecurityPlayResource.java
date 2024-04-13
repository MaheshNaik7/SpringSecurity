package com.Springbootsecurity.FormAuthentication.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {
	
	//SpringSecurity-CSRF -> Cross Site Resource Forgery
	//creating csrf token
	
	
	@GetMapping({"/csrftoken"})
	public CsrfToken retriveCsrfToken(HttpServletRequest request){
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	

}