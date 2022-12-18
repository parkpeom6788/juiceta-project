package org.kosta.juicetaproject.service;

import org.kosta.juicetaproject.model.vo.MemberVO;

public interface CartAndWishlistService {

	String addWishlist(MemberVO memberVO, int productNo);
	
}
