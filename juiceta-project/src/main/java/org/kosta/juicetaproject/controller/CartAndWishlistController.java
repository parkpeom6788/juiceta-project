package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.service.CartAndWishlistService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartAndWishlistController {
	private final CartAndWishlistService cartAndWishlistService;
	
	// 찜목록 담기 
	@PostMapping("addWishlistAjax")
	@ResponseBody
	public String addWishlist(@AuthenticationPrincipal MemberVO memberVO, int productNo) {
		return cartAndWishlistService.addWishlist(memberVO,productNo);	// fail (이미 존재함), ok (찜목록에 추가함)
	}
	
	// 카트에 담긴 상품 리스트 출력 시키기 
	@RequestMapping("/findCartAllListById") 
	public String findCartAllListById(@AuthenticationPrincipal MemberVO memberVO , Model model) {		
		model.addAttribute("cartAllList", cartAndWishlistService.findCartAllListById(memberVO.getId()));
		model.addAttribute("cartTotal", cartAndWishlistService.totalCountPrice(memberVO.getId()));
		return "order/cart";
	}

	// 카트에 추가하는 Ajax 
	@PostMapping("addCartAjax")
	@ResponseBody
	public String addCart(@AuthenticationPrincipal MemberVO memberVO, int productNo, int productCount) {
		return cartAndWishlistService.addCart(memberVO,productNo,productCount);
	}

	@RequestMapping("getTotalCartByIdAjax")
	@ResponseBody
	public int getTotalCartById(@AuthenticationPrincipal MemberVO memberVO) {
		return cartAndWishlistService.getTotalCartById(memberVO.getId());
	}

	@PostMapping("removeWishlist")
	public String removeWishlist(int productNo) {
		cartAndWishlistService.removeWishlist(productNo);
		return "redirect:removeWishlistResult";
	}
	
	@RequestMapping("removeWishlistResult")
	public String removeWishlistResult() {
		return "order/wishlistRemoveResult";
	}
	
	@RequestMapping("wishlist")
	public String Wishlist(@AuthenticationPrincipal MemberVO memberVO , Model model) {
		model.addAttribute("wishlistAllList",cartAndWishlistService.findWishlistById(memberVO.getId()));
		return "order/wishlist";
	}
	
	// 카트에 담긴 물품 삭제
	@PostMapping("removeCart")
	public String removeCart(int productNo) {
		cartAndWishlistService.deleteCartById(productNo);
		return "redirect:removeCartResult";
	}
	
	@RequestMapping("removeCartResult")
	public String removeCartResult() {
		return "order/cartRemoveResult";
	}
	
}