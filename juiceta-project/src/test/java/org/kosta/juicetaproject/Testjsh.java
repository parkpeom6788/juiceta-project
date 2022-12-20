package org.kosta.juicetaproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.CartAndWishlistMapper;
import org.kosta.juicetaproject.model.mapper.MemberMapper;
import org.kosta.juicetaproject.model.mapper.OrderMapper;
import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.ShopPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testjsh {
	private final ProductMapper productMapper;
	private final MemberMapper memberMapper;
	private final CartAndWishlistMapper cartAndWishlistMapper;
	private final OrderMapper orderMapper;

	@Autowired
	public Testjsh(ProductMapper productMapper, MemberMapper memberMapper, CartAndWishlistMapper cartAndWishlistMapper, OrderMapper orderMapper) {
		super();
		this.productMapper = productMapper;
		this.memberMapper = memberMapper;
		this.cartAndWishlistMapper = cartAndWishlistMapper;
		this.orderMapper = orderMapper;
	}

	@Test
	void contextLoads() {
		System.out.println(productMapper);
	}
	
	@Test
	void findProductAllList() {
		int totalProductCount = productMapper.getTotalProductCount();
		String pageNo = "";
		ShopPagination shopPagination = null;
		
		if(pageNo=="")
			shopPagination = new ShopPagination(totalProductCount);
		else
			shopPagination = new ShopPagination(Integer.parseInt(pageNo), totalProductCount);

		List<ProductVO> list = productMapper.findShopProductAllList(shopPagination);
		for(ProductVO vo : list)
			System.out.println(vo);
	}
	
	@Test
	void findProductAllListByCateory() {
		int totalProductCount = productMapper.getTotalProductCount();
		String pageNo = "";
		ShopPagination shopPagination = null;
		
		if(pageNo=="")
			shopPagination = new ShopPagination(totalProductCount);
		else
			shopPagination = new ShopPagination(Integer.parseInt(pageNo), totalProductCount);
		
		String category = "Tea";
		Map<String, Object> map = new HashMap<>();
		map.put("PAGINATION", shopPagination);
		map.put("CATEGORY", category);
		
		List<ProductVO> list = productMapper.findProductAllListByCategory(map);
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
	
	@Test
	void findWishlistByIdAndProductNo() {
		String id = "jtest1";
		int productNo = 126;
		Map<String, Object> map = new HashMap<>();
		map.put("ID",id);
		map.put("PRODUCT_NO", productNo);
		int result = cartAndWishlistMapper.findWishlistByIdAndProductNo(map);
		System.out.println(result);
	}
	
	@Test
	void findProductByProductNameKeyword() {
		String keyword = "양";
		List<ProductVO> list = productMapper.findProductByProductNameKeyword(keyword);
		for(ProductVO vo : list)
			System.out.println(vo);
	}
	
	@Test
	void findCartByIdAndProductNo() {
		String id = "jtest3";
		int productNo = 332;
		Map<String, Object> map = new HashMap<>();
		map.put("ID", id);
		map.put("PRODUCT_NO", productNo);
		int result = cartAndWishlistMapper.findCartByIdAndProductNo(map);
		Assertions.assertEquals(1, result);
	}
	
	@Test
	void addCart() {
		String id = "jtest3";
		int productNo = 64;
		int productCount = 1;
		Map<String, Object> map = new HashMap<>();
		map.put("ID", id);
		map.put("PRODUCT_NO", productNo);
		map.put("PRODUCT_COUNT", productCount);
		cartAndWishlistMapper.addCart(map);
		int result = cartAndWishlistMapper.findCartByIdAndProductNo(map);
		Assertions.assertEquals(1, result);
	}
	
	@Test
	void getTotalCartById() {
		String id = "jtest3";
		int totalCount = cartAndWishlistMapper.getTotalCartById(id);
		System.out.println(totalCount);
	}
	
	@Test
	void placeAnOrder() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("jtest3");
		
		// 주문하기
		OrderVO orderVO = OrderVO.builder().receiverName("강하늘").receiverPhone("000000000").receiverAddress("오리").memberVO(memberVO).build();
		System.out.println("주문 DB저장 전 : "+orderVO);
		orderMapper.placeAnOrder(orderVO);
		System.out.println("주문 DB저장 후 : "+orderVO);
		
		// 주문상세
		int productNo = 332;
		int productCount = 2;
		int orderNo = orderVO.getOrderNo();
		Map<String, Integer> map = new HashMap<>();
		map.put("PRODUCT_NO", productNo);
		map.put("PRODUCT_COUNT", productCount);
		map.put("ORDER_NO", orderNo);
		orderMapper.placeAnOrderDetail(map);
	}

}





















