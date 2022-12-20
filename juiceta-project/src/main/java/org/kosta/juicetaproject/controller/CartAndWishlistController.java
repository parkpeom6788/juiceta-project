package org.kosta.juicetaproject.controller;

import java.util.List;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.service.CartAndWishlistService;
import org.kosta.juicetaproject.service.MemberService;
import org.kosta.juicetaproject.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class CartAndWishlistController {
	
	private final CartAndWishlistService cartAndWishlistService;
	private final MemberService memberService;
	private final ProductService productService;
	
	// 장바구니 담기 
	@RequestMapping("addWishlistAjax")
	@ResponseBody
	public String addWishlist(@AuthenticationPrincipal MemberVO memberVO, int productNo) {
		String result = cartAndWishlistService.addWishlist(memberVO,productNo);	// fail (이미 존재함), ok (찜목록에 추가함)
		return result;
	}
	
	// 카트에 담긴 상품 리스트 출력 시키기 
	@RequestMapping("/findCartAllListById") 
	public String findCartAllListById(@AuthenticationPrincipal MemberVO memberVO , Model model) {		
		
		// 세션을 이용하여 아이디를 가져옴 
		List<ProductVO> productList= cartAndWishlistService.findCartAllListById(memberVO.getId());
		model.addAttribute("productAllList", productList);
		return "/order/cart";
	}
	
	@RequestMapping("addCartAjax")
	@ResponseBody
	public String addCart(@AuthenticationPrincipal MemberVO memberVO, int productNo, int productCount) {
		String result = cartAndWishlistService.addCart(memberVO,productNo,productCount);
		return result;
	}
	
	@RequestMapping("getTotalCartByIdAjax")
	@ResponseBody
	public int getTotalCartById(@AuthenticationPrincipal MemberVO memberVO) {
		return cartAndWishlistService.getTotalCartById(memberVO.getId());
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