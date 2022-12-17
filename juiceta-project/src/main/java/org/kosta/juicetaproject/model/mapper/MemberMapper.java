package org.kosta.juicetaproject.model.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.Authority;
import org.kosta.juicetaproject.model.vo.MemberVO;
@Mapper
public interface MemberMapper {

	MemberVO findMemberById(String id);

	List<String> getAddressList();

	List<MemberVO> findMemberListByAddress(String address);	

	int getMemberCount();

	void updateMember(MemberVO vo);

	void registerMember(MemberVO vo);

	int idcheck(String id);

	List<Authority> findAuthorityById(String id);

	void registerRole(Authority authority);

	void deleteMember(String id);

	String findMemberId(MemberVO memberVO);

	int findMemberPassword(MemberVO memberVO);

}