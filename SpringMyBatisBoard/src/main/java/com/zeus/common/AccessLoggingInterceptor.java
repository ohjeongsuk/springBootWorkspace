package com.zeus.common;

import java.lang.reflect.Method;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessLoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

		HandlerMethod methodObj = (HandlerMethod) handler;
		Method method = methodObj.getMethod();

		Class cla = method.getDeclaringClass();
		String className = cla.getName();
		String classSimpleName = cla.getSimpleName();
		String methodName = method.getName();
		
		log.info("[ACCESS CONTROLLER] " +request.getRequestURI()+" "+ className + "." + methodName);
	}

}
