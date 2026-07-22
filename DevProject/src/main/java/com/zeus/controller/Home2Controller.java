package com.zeus.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class Home2Controller {
	//의존성 주입
	@Autowired
	private MessageSource messageSource;
	
	//1번 방식
	@RequestMapping(value = "/home/mainpage", method = RequestMethod.GET)
	public String home(Locale locale,Model model) {
		log.info("/home/page");
		String[] args = {"Lee"};  
		// 스프링 프레임워크로부터 MessageSource를 주입 받은 다음 getMessage 메서드를 호출한다.  
		String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);  
		String message2 = messageSource.getMessage("welcome.message", args, Locale.ENGLISH); 
		log.info("Welcome message : " + message);  
		log.info("Welcome message2 : " + message2); 
		
		return "home/mainpage";
	}
	
		
	
}
