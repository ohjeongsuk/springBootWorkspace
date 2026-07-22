package com.zeus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zeus.common.BoardIntercepter;
import com.zeus.common.LoginIntercepter;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer{

	//인터셉터할 대상을 등록함
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/login/insert");
		registry.addInterceptor(new BoardIntercepter()).addPathPatterns("/board/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
