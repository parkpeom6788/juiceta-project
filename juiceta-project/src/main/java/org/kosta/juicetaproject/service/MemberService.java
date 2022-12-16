package org.kosta.juicetaproject.service;

import java.util.List;


import org.kosta.juicetaproject.model.vo.Authority;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public interface MemberService {
	
	MemberVO findMemberById(String id);

	List<String> getAddressList();

	List<MemberVO> findMemberListByAddress(String address);

	int getMemberCount();

	void updateMember(MemberVO vo);

	void registerMember(MemberVO vo);

	String idcheck(String id);
	
	List<Authority> findAuthorityById(String id);
	
	void deleteMemberAction(@AuthenticationPrincipal MemberVO memberVO, String password);

	String findMemberId(MemberVO memberVO);

}
