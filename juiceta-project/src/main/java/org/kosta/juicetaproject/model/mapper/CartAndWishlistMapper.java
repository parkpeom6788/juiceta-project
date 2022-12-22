package org.kosta.juicetaproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.ProductVO;

@Mapper
public interface CartAndWishlistMapper {

	int findWishlistByIdAndProductNo(Map<String, Object> map);
	
	void addWishlist(Map<String, Object> map); 

	int findCartByIdAndProductNo(Map<String, Object> map); // 장바구니에 상품 담기 

	void addCart(Map<String, Object> map); // 상품 추가 

	int getTotalCartById(String id); // 상품에 담긴 총 개수 

	List<Map<String, Object>> findCartAllListById(String id); // 장바구니에 장바구니에 담긴 목록 출력 

	int countCartById(String id); // 장바구니에 담긴 상품 카운트 개수 

	void deleteCartById(int productNo); // 아이디에 담긴 장바구니 상품 삭제 클릭시  
	
	List<ProductVO> findWishlistAllListById(String id); // 장바구니 리스트 조회 

	void removeWishlist(int productNo); // 찜 삭제 

	int totalCountPrice(String id); // 장바구니에 담긴 상품 가격
	
}
