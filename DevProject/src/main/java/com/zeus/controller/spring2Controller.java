package com.zeus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class spring2Controller {
	@RequestMapping(value = "/spring2/form1", method = RequestMethod.GET)
	public String spring2form1(Model model) {
		
		return "/spring2/form1";
	}
	
	@RequestMapping(value = "/spring2/form2", method = RequestMethod.GET)
	public void spring2form2(Model model) {
		
		//return "/spring2/form1";
	}
	
	@RequestMapping(value = "/spring2/form3", method = RequestMethod.GET)
	@ResponseBody
	public Member spring2form3(Model model) {
		Member member = new Member();
		return member;
	}
	
	@RequestMapping(value = "/spring2/form4", method = RequestMethod.GET)
	public ResponseEntity<Member> spring2form4(Model model) {
		
		Member member = new Member();
		ResponseEntity<Member> entity = new ResponseEntity<Member>(member,HttpStatus.OK);
		return entity;
		
	}
}
