package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		log.info("/home");
	
		return "home";
	}

	@RequestMapping(value = "/login/insertForm", method = RequestMethod.GET)
	public String loginInsertForm() {
		log.info("/login/insertForm");
		return "login/insertForm";
	}

	@RequestMapping(value = "/login/insert", method = RequestMethod.POST)
//	@ResponseBody
	public String loginInsert(Member member, Model model) {
		log.info("login");
		log.info("login userId = " + member.getUserId());
		log.info("login userPw = " + member.getUserPw());
//		model.addAttribute("result", "로그인 되었습니다.");
		model.addAttribute("member", member);

		return "login/success";
	}
}
