package com.zeus.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zeus.common.security.domain.CustomUser;
import com.zeus.domain.Member;
import com.zeus.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired 
	private MemberMapper memberMapper; 
	
	//시큐리티가 사용자로 부터 username, password에서 username 매개변수 전달
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("Load User By UserName : " + username); 
		 
		// userName은 사용자명이 아니라 사용자 아이디이다. 
		Member member = memberMapper.select(username); 
		log.info("queried by member mapper: " + member); 
		 
		return member == null ? null : new CustomUser(member); 
	}

}
