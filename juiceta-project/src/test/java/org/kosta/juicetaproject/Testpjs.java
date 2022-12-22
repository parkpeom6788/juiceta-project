package org.kosta.juicetaproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.OrderMapper;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderDetailVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
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
		int totalProductCount = productMapper.getTotalProductCount(); // 총상품수를 구하는 메서드
		String pageNo = ""; //페이지번호 변수
		Pagination pagination = null; //페이지네이션사용을위해 선언
		
		if(pageNo=="") //만약 페이지번호가 없을 때 
			pagination = new Pagination(totalProductCount); //페이지네이션 변수에 총상품수를 매개변수로 담아준다
		else // 페이지번호가 있을 때
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);
			// 페이지네이션 변수에 페이지번호와 총상품수를 매개변수에 넣어준다

		List<ProductVO> list = productMapper.findAllProduct(pagination); 
		//ProductVO 타입만 들어올 수 있는 리스트에 페이지네이션을  
		// 전체상품리스트를 구하는 메서드에 매개변수로 넣어준다
		for(ProductVO vo : list) // list.size만큼 반복문을 돌려줘서 
			System.out.println(vo);// vo 값들을 출력한다
	}
	@Test
	void findOrderById() {
		MemberVO memberVO=new MemberVO();
		memberVO.setId("jtest3");
		OrderDetailVO OrderDetailVO=orderMapper.findOrderById(memberVO.getId());
		System.out.println(OrderDetailVO);
	}
	@Test
	void findCountProductByKeyword() {
		String keyword="양배추";
		int result=productMapper.findCountProductByKeyword(keyword);
		System.out.println(result);
	}
	//주문번호에 대해 주문번호 주문날짜 배송주소를 출력
	@Test
	void findOrderInfoByOrderNo() {
		int orderNo=43;
		OrderVO orderVO=orderMapper.findOrderInfoByOrderNo(orderNo);
		System.out.println(orderVO);
	}
	//주문번호를 통해 상품명,주문수량,총합계를 출력
	@Test
	void findOrderTotalPriceInfoByOrderNo() {
		int orderNo=1;
		List<Map<String, Object>> list=orderMapper.findOrderTotalPriceInfoByOrderNo(orderNo);
		System.out.println(list);
	}
	//아이디,주문번호,제품번호로 작성한 리뷰 갯수 출력
	@Test
	void findTotalCountReview() {
		String id="java189";
		int orderNo=4;
		int productNo=332;
		int count=orderMapper.findTotalCountReview(id,orderNo,productNo);
		System.out.println(count);
	}
}

















