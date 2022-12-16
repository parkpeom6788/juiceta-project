package org.kosta.juicetaproject;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testjsh {
	private final ProductMapper productMapper;
	
	@Autowired
	public Testjsh(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
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
	void registerProduct() {
		ProductVO productVO = ProductVO.builder().productName("토마토차").price(8500).productCount(10).productDetail("맛있는 토마토차").image("product-5.jpg").category("과일차").build();
		int result = productMapper.registerProduct(productVO);
		Assertions.assertEquals(1, result);
	}
	
	
}





















