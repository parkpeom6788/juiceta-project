package org.kosta.juicetaproject;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.MemberMapper;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testjsh {
	private final ProductMapper productMapper;
	private final MemberMapper memberMapper;

	@Autowired
	public Testjsh(ProductMapper productMapper, MemberMapper memberMapper) {
		super();
		this.productMapper = productMapper;
		this.memberMapper = memberMapper;
	}

	@Test
	void contextLoads() {
		System.out.println(productMapper);
	}
	
	@Test
	void findProductAllList() {
		List<ProductVO> list = productMapper.findProductAllList();
		for(ProductVO vo : list)
			System.out.println(vo);
	}
	
	@Test
	void findMemberId() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("jtest");
		memberVO.setPhone("000000000");
		String id = memberMapper.findMemberId(memberVO);
		System.out.println(id);
	}
	
	@Test
	void findMemberPassword() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("jtest0");
		memberVO.setName("아이유");
		memberVO.setPhone("000000000");		
		int result = memberMapper.findMemberPassword(memberVO);
		Assertions.assertEquals(1, result);
	}

}





















