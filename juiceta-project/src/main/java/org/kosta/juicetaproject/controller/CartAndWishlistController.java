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
	
	@RequestMapping("addWishlistAjax")
	@ResponseBody
	public String addWishlist(@AuthenticationPrincipal MemberVO memberVO, int productNo) {
		String result = cartAndWishlistService.addWishlist(memberVO,productNo);	// fail (이미 존재함), ok (찜목록에 추가함)
		return result;
	}

}













