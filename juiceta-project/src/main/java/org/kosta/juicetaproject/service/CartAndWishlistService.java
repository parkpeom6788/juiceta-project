package org.kosta.juicetaproject.service;

import org.kosta.juicetaproject.model.vo.MemberVO;

public interface CartAndWishlistService {

	String addWishlist(MemberVO memberVO, int productNo);

	String addCart(MemberVO memberVO, int productNo, int productCount);

	int getTotalCartById(String id);
	
}
