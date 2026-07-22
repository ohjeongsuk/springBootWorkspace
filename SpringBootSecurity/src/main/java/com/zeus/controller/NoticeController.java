package com.zeus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {

	@PreAuthorize("hasRole('ROLE_MEMBER')")
	@RequestMapping("/notice/list")
	public String list() {
		log.info("list : 모두가 접근 가능");
		return "notice/list"; 
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/notice/insertForm")
	public String insertForm() {
		log.info("insertForm : 관리자만 접근 가능");
		return "notice/insertForm";
	}
}
