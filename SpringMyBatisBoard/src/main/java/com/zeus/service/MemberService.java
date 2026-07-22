package com.zeus.service;

import java.util.List;

import com.zeus.domain.Member;

public interface MemberService {
	
	//insert
	public boolean insert(Member member) throws Exception;
	
	//list
	public List<Member> list() throws Exception;

	//update
	public boolean update(Member member) throws Exception;
	
	//deleteMember
	public boolean deleteMember(Member member) throws Exception;

	//deleteAuth
	public boolean deleteAuth(Member member) throws Exception;
	
	//selectMember
	public Member selectMember(Member member) throws Exception;
}
