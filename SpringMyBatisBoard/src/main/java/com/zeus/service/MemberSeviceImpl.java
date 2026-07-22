package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;
import com.zeus.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberSeviceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	
	@Override
	@Transactional
	public boolean insert(Member member) throws Exception {
		if (member == null || member.getUserId().isEmpty() == true || member.getUserPw().isEmpty() == true) {
			return false;
		}
		log.info("MemberServiceImpl 1= "+member.toString());
		int count = mapper.insertMember(member);
		log.info("MemberServiceImpl 2= "+member.toString());
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		int count2 = mapper.insertAuth(memberAuth);
		
		return (count == 0 || count2 == 0) ? false : true;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Member> list() throws Exception {
		return mapper.list();
	}
	
	@Override
	@Transactional
	public boolean update(Member member) throws Exception {
		int count = mapper.updateMember(member);
		
		//사용자 인가권한 요청했을경우(사용자 => 회원, 관리자)
		//사용자 권한 모두삭제
		mapper.deleteAuth(member);
		
		//수정된 사용자 권한을 가져온다.
		List<MemberAuth> authList = member.getAuthList();
		
		if (authList != null) {
			for (MemberAuth memberAuth : authList) {
				if (memberAuth.getAuth() == null || memberAuth.getAuth().trim().length() == 0) {
					continue;
				}
				memberAuth.setUserNo(member.getUserNo());
				mapper.insertAuth(memberAuth);
			}
		}
		
		return count == 0 ? false : true;
	}


	@Override
	@Transactional
	public boolean deleteMember(Member member) throws Exception {
		int count = mapper.deleteMember(member);
		return count == 0 ? false : true;
	}


	@Override
	@Transactional
	public boolean deleteAuth(Member member) throws Exception {
		int count = mapper.deleteAuth(member);
		return count == 0 ? false : true;
	}


	@Override
	@Transactional(readOnly = true)
	public Member selectMember(Member member) throws Exception {
		return mapper.selectMember(member);
	}
}
