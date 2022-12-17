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
	@Test
	void updateProduct() {
		int productNo=6;
		ProductVO productVO=new ProductVO(productNo, "브로콜리즙", 14000, 30, "맛있는 브로콜리즙", "product-6.jpg", "과일즙");
		int result=productMapper.updateProduct(productVO);
		System.out.println(result);
	}
	@Test
	void registerProduct() {
		ProductVO productVO=new ProductVO(11, "test2", 5, 5, "test2", "product-11.jpg", "test3");
		int result=productMapper.registerProduct(productVO);
		System.out.println(result);
	}
	@Test
	void deleteProduct() {
		int productNo=49;
		int result=productMapper.deleteProduct(productNo);
		System.out.println(result);
	}
}

















