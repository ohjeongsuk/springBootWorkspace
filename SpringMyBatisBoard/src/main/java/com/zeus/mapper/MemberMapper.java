package com.zeus.mapper;

import java.util.List;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;

public interface MemberMapper {
	public int insertMember(Member member) throws Exception; 
	public int insertAuth(MemberAuth memberAuth) throws Exception;
	public Member selectMember(Member member) throws Exception; 
	public List<Member> list() throws Exception;
	public int updateMember(Member member) throws Exception; 
	public int deleteMember(Member member) throws Exception;
	public int deleteAuth(Member member) throws Exception;
}
