package com.zeus.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;
import com.zeus.common.security.CustomUserDetailsService;

import jakarta.servlet.DispatcherType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity // spring security 웹 보안 할성화 선언
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

	@Autowired
	DataSource dataSource;

	@Bean // 자동으로 기본 시큐리티 설정이 수동 설정(커스텀 설정)으로 대체
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("시큐리티 환경설정");
		// 1. csrf 토큰 비활성화
		http.csrf(csrf -> csrf.disable());
		// 2-1. 접근제한정책(인증,인가)
		http.authorizeHttpRequests(auth -> auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/error/accessError", "/login", "/logout", "/css/**", "/js/**", "/error").permitAll()
				//.requestMatchers("/board/list").permitAll() // 게시판 목록: 누구나
				//.requestMatchers("/board/insertForm").hasRole("MEMBER") // 게시판 등록: 회원만
				//.requestMatchers("/notice/list").permitAll() // 공지사항 목록: 누구나
				//.requestMatchers("/notice/insertForm").hasRole("ADMIN") // 공지사항 등록: 관리자만
				.anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
		);
		// 2-2. 위배된 접근제한정책 처리 (포워딩(Forwarding)처리)
		// http.exceptionHandling(exception ->
		// exception.accessDeniedPage("/error/accessError"));
		http.exceptionHandling(exception -> exception.accessDeniedHandler(createAccessDeniedHandler()));

		// 3. 기본 시큐리트가 가지고 있는 로그인폼을 활성화 =>사용자가 정의한 로그인폼으로 변경하겠다.(조심해야될것 4가지)
		http.formLogin(form -> form.loginPage("/login/insertForm") // 커스텀 로그인 페이지가 있다면 지정
				.loginProcessingUrl("/login") // (post) (/login) Security 낙아채서 가져감, Id(username), pwd(password)
				// .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 기본 URL
				.successHandler(createAuthenticationSuccessHandler()).permitAll());

		// 4. 로그아웃처리(2가지 조심)
		// 로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화 한다.
		http.logout(logout -> logout.logoutUrl("/logout") // 로그아웃을 처리할 URL post (기본값: /logout) security 낙아챔
				.logoutSuccessUrl("/") // 로그아웃 성공 시 이동할 페이지
				.invalidateHttpSession(true) // HTTP 세션 무효화 (기본값: true)
				.deleteCookies("JSESSIONID", "remember-me") // 로그아웃 시 관련 쿠키 삭제
				.permitAll() // 로그아웃 요청은 누구나 접근 가능해야 함
		);

		// 5. 쿠키의 유효 시간을 지정한다(24시간).
		http.rememberMe(remember -> remember.key("zeus")// 인증토큰생성시 사용할키 (보안상 중요)
				.tokenRepository(createJDBCRepository())// DB를 이용한 토큰 저장소 설정
				.tokenValiditySeconds(60 * 60 * 24) // 토큰유효기간(24시간)
		);

		// security 정책 설정활성화
		return http.build();
	}

//	@Autowired
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// CustomUserDetailsService 빈을 인증 제공자에 지정한다.
//		auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
//	}
	
	
	private PersistentTokenRepository createJDBCRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}

	// 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다. @Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	// CustomLoginSuccessHandler를 빈으로 등록한다.
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
