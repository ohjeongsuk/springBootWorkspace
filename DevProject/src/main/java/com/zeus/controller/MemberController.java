package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	//1.문자열 한개 전송(string),2.객체전송(member),3.list<객체>
	@RequestMapping(value = "/member/model01",method = RequestMethod.GET)
	public String model01(Member member,RedirectAttributes rttr) {
		log.info("member ="+member);
		rttr.addFlashAttribute("member",member);
		return "redirect:/member/result";
	}

	@RequestMapping(value = "/member/result",method = RequestMethod.GET)
	public String result() {
		log.info("result ");
		return "member/result";
	}
}





		
//		ArrayList<Member> list = new ArrayList<Member>();
//		for (int i = 1; i < 4; i++) {
//			Member member = new Member();
//			member.setUserId("123456");
//			member.setEmail("aaa@naver.com");
//			member.setPassword("password");
//			list.add(member);
//		}
//		
//		model.addAttribute("list",list);
		
		
		
