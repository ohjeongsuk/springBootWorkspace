package com.zeus.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {
	
	//exception 예외처리가 발생하면 처리하는 핸들러함수등록
	@ExceptionHandler(Exception.class)
	public String exceptionHandle(Exception e, Model model) {
		log.info("********"+e.toString());
		model.addAttribute("exception",e);
		return "error/errorCommon";
	}
	
}
