package org.kosta.juicetaproject.model.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.CartVO;

@Mapper
public interface CartAndWishlistMapper {

	int findWishlistByIdAndProductNo(Map<String, Object> map);
	
	void addWishlist(Map<String, Object> map);

	// 리스트 목록 추가
	ArrayList<CartVO> findCartAllListById(String id);

	int findCartByIdAndProductNo(Map<String, Object> map);

	void addCart(Map<String, Object> map);

	int getTotalCartById(String id);


}
