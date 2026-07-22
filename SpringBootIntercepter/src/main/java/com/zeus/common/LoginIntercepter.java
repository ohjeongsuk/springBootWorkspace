package com.zeus.common;

import java.lang.reflect.Method;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 경로설정
		// /login ~~ preHandle() /login/insert
		log.info("/login ~~ preHandle()" + request.getRequestURI());
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		// 객체주소
		log.info("/login ~~ preHandle() bean =" + method.getBean());
		// 함수
		log.info("/login ~~ preHandle() method =" + methodObj);
		// 세션이 존재유무 체크 : 세션(전역객체 MAP ->키값 : 밸류객체)
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

		// /login ~~ postHandle()/login/insert
		log.info("/login ~~ postHandle()" + request.getRequestURI());
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		// 객체주소
		// /login ~~ postHandle() bean =com.zeus.controller.LoginController@252850c1
		log.info("/login ~~ postHandle() bean =" + method.getBean());
		// 함수
		// /login ~~ postHandle() method =public java.lang.String com.zeus.controller.LoginController
		// .loginInsert(com.zeus.domain.Member,org.springframework.ui.Model)
		log.info("/login ~~ postHandle() method =" + methodObj);

		// 세션이 존재유무 체크 : 세션(전역객체 MAP ->키값 : 밸류객체)
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("member");
		
		log.info("/login ~~ postHandle() member =", member);
		if (member != null) {
			log.info("/login ~~ postHandle() member =" + member);
			//세션에는 사용자 정보 등록
			session.setAttribute("userInfo", member);
			response.sendRedirect("/home");
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
		log.info("/login ~~ afterCompletion()" + request.getRequestURI());
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		// 객체주소
		log.info("/login ~~ afterCompletion() bean =" + method.getBean());
		// 함수
		log.info("/login ~~ afterCompletion() method =" + methodObj);
	}

}
