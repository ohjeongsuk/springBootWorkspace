package com.zeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Member;
import com.zeus.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	// 입력창화면 요청
	@GetMapping(value = "/user/insertForm")
	public String userInsertForm(Member member, Model model) {
		model.addAttribute("member", member);
		return "user/insertForm";
	}

	// 입력저장 요청
	@PostMapping(value = "/user/insert")
	public String userInsert(Member member, Model model) throws Exception {
		
		log.info("user/insert" + member.toString());
		boolean result = service.insert(member);
		if (result == true) {
			return "user/success";
		} 
		return "user/false";
	}
	
	// 사용자 리스트 화면 요청
	@GetMapping(value = "/user/list")
	public String userList(Member member, Model model) throws Exception {
		List<Member> memberList = service.list();
		model.addAttribute("list",memberList);
		return "user/list";
	}
	
	// 사용자 수정화면 요청
	@GetMapping(value = "/user/updateForm")
	public String userUpdateForm(Member member, Model model) throws Exception {
		model.addAttribute("member",service.selectMember(member));
		return "user/updateForm";
	}
	
	// 사용자 수정내용 요청
	@PostMapping(value = "/user/update")
	public String userUpdate(Member member, Model model) throws Exception {
		boolean result = service.update(member);
		if (result == false) {
			return "user/false";
		}
		return "user/success";
	}
	
	// 사용자 삭제 요청
	@GetMapping(value = "/user/deleteMember")
	public String userDeleteMember(Member member, Model model) throws Exception {
		boolean result = service.deleteMember(member);
		if (result == false) {
			return "user/false";
		}
		return "user/success";
	}
	
	// 사용자권한 삭제 요청
	@GetMapping(value = "/user/deleteAuth")
	@ResponseBody
	public boolean userDeleteAuth(Member member, Model model) throws Exception {
		member.setUserNo(13);
		return service.deleteMember(member);
	}

	// 사용자 정보(select) 요청
	@GetMapping(value = "/user/selectMember")
	public String userSelectMember(Member member, Model model) throws Exception {
		model.addAttribute("member", service.selectMember(member));
		return "user/selectMember";
	}
}