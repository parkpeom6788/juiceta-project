package org.kosta.juicetaproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.OrderMapper;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderDetailVO;
import org.kosta.juicetaproject.model.vo.Pagination;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class Testpjs {
	private final ProductMapper productMapper;
	private final OrderMapper orderMapper;
	@Autowired
	public Testpjs(ProductMapper productMapper,OrderMapper orderMapper) {
		super();
		this.productMapper = productMapper;
		this.orderMapper= orderMapper;
	}
	@Test
	void productDetail() {
		int productNo=1;
		ProductVO productVO=productMapper.findProductByProductNo(productNo);
		System.out.println(productVO);
	}
	@Test
	void updateProduct() {
		int productNo=6;
		ProductVO productVO=new ProductVO(productNo, "브로콜리즙", 14000, 30, "맛있는 브로콜리즙", "product-6.jpg", "과일즙",0);
		int result=productMapper.updateProduct(productVO);
		System.out.println(result);
	}
	@Test
	void registerProduct() {
		ProductVO productVO=new ProductVO(11, "test2", 5, 5, "test2", "product-11.jpg", "test3",0);
		int result=productMapper.registerProduct(productVO);
		System.out.println(result);
	}
	@Test
	void deleteProduct() {
		int productNo=49;
		int result=productMapper.deleteProduct(productNo);
		System.out.println(result);
	}

	/*
	 * @Test void productAllListByRnum() { List<ProductVO>
	 * list=productMapper.productAllListByRnum(); System.out.println(list); }
	 */
	@Test
	void findProductListByKeyword() {
		int totalProductCount =productMapper.getTotalProductCount();
		String pageNo="";
		Pagination pagination = null;
		
		if(pageNo=="")
			pagination = new Pagination(totalProductCount);
		else {
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);
		}
		String keyword = "파";
		Map<String, Object> map = new HashMap<>();
		map.put("PAGINATION", pagination);
		map.put("KEYWORD",keyword);
		
		List<ProductVO> list = productMapper.findProductListByKeyword(map);
		for(ProductVO vo : list)
			System.out.println(vo);
	}
	@Test
	void productAllListByRnum() {
		int totalProductCount = productMapper.getTotalProductCount();
		String pageNo = "";
		Pagination pagination = null;
		
		if(pageNo=="")
			pagination = new Pagination(totalProductCount);
		else
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);

		List<ProductVO> list = productMapper.findAllProduct(pagination);
		for(ProductVO vo : list)
			System.out.println(vo);
	}
	@Test
	void findOrderById() {
		MemberVO memberVO=new MemberVO();
		memberVO.setId("jtest3");
		OrderDetailVO OrderDetailVO=orderMapper.findOrderById(memberVO.getId());
		System.out.println(OrderDetailVO);
	}
}

















