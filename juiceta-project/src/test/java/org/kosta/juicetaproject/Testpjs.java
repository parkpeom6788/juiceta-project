package org.kosta.juicetaproject;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class Testpjs {
	private final ProductMapper productMapper;
	@Autowired
	public Testpjs(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}
	@Test
	void productDetail() {
		int productNo=1;
		ProductVO productVO=productMapper.productDetail(productNo);
		System.out.println(productVO);
	}
}

















