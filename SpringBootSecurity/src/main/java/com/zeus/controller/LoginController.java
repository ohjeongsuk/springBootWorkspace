package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@RequestMapping("/login/insertForm")
	public String insertForm() {
		log.info("list : 모두가 접근 가능");
		
		return "login/insertForm";
	}
	
	@RequestMapping("/logout/logoutForm") 
	public String logoutForm() { 
	log.info("logoutForm"); 
	return "login/logoutForm"; 
	} 

	
}
