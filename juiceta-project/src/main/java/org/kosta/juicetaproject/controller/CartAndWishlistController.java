package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.service.CartAndWishlistService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartAndWishlistController {
	private final CartAndWishlistService cartAndWishlistService;
	
	// 장바구니 담기 - 수현이가완료 
	@RequestMapping("addWishlistAjax")
	@ResponseBody
	public String addWishlist(@AuthenticationPrincipal MemberVO memberVO, int productNo) {
		String result = cartAndWishlistService.addWishlist(memberVO,productNo);	// fail (이미 존재함), ok (찜목록에 추가함)
		return result;
	}
	
	// 카트에 담긴 상품 리스트 출력 시키기 
	@RequestMapping("/findCartAllListById") 
	public String findCartAllListById(@AuthenticationPrincipal MemberVO memberVO) {		
		return "/order/cart.html";
	}

	@RequestMapping("addCart")
	public String addCart() {
		return "";
	}
	
	@RequestMapping("removeCart")
	public String removeCart() {
		return "";
	}
	
	@RequestMapping("findWishlistAllListById")
	public String findWishlistAllListById() {
		return "";
	}

	@RequestMapping("removeWishlist")
	public String removeWishlist() {
		return "";
	}
}