package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ProductVO;

public interface CartAndWishlistService {

	String addWishlist(MemberVO memberVO, int productNo);

	String addCart(MemberVO memberVO, int productNo, int productCount);

	int getTotalCartById(String id);

	List<ProductVO> findCartAllListById(String id);

	List<ProductVO> findWishlistById(String id);

	void removeWishlist(int productNo);

	void deleteCartById(int productNo); // 카트에 담긴 물품 삭제

	int totalCountPrice(String id); // 카트에 담긴 총 물품 가격 
	
}
