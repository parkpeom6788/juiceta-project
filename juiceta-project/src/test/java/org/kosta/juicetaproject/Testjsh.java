package org.kosta.juicetaproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.MemberMapper;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
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
	
	

}





















