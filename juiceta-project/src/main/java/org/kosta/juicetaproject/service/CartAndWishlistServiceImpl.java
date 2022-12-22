package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.CartAndWishlistMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartAndWishlistServiceImpl implements CartAndWishlistService {
	private final CartAndWishlistMapper cartAndWishlistMapper;
	
	@Override
	public String addWishlist(MemberVO memberVO, int productNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("ID", memberVO.getId());
		map.put("PRODUCT_NO", productNo);
		String result = "";
		int check = cartAndWishlistMapper.findWishlistByIdAndProductNo(map);	// 찜목록에 상품 존재 유무 확인
		if(check>0) {
			result = "fail";
		}else {
			cartAndWishlistMapper.addWishlist(map);
			result = "ok";
		}
		return result;
	}
	@Override
	public String addCart(MemberVO memberVO, int productNo, int productCount) {
		Map<String, Object> map = new HashMap<>();
		map.put("ID", memberVO.getId());
		map.put("PRODUCT_NO", productNo);
		map.put("PRODUCT_COUNT", productCount);
		String result = "";
		int check = cartAndWishlistMapper.findCartByIdAndProductNo(map);	// 장바구니목록에 상품 존재 유무 확인
		if(check>0) {
			result = "fail";
		}else {
			cartAndWishlistMapper.addCart(map);
			result = "ok";
		}
		return result;
	}
	
	// 카트에 담긴 총 가격의 액수  
	@Override
	public int getTotalCartById(String id) {
		return cartAndWishlistMapper.getTotalCartById(id);
	}
	
	@Override
	public List<Map<String, Object>> findCartAllListById(String id) {
		return cartAndWishlistMapper.findCartAllListById(id);
	}
	
	@Override
	public List<ProductVO> findWishlistById(String id) {
		return cartAndWishlistMapper.findWishlistAllListById(id);
	}
	
	@Override
	public void removeWishlist(int productNo) {
		 cartAndWishlistMapper.removeWishlist(productNo);
	}

	// 카트 삭제
	@Override
	public void deleteCartById(int productNo) {
		cartAndWishlistMapper.deleteCartById(productNo);
	}
	@Override
	public int totalCountPrice(String id) {
		return cartAndWishlistMapper.totalCountPrice(id);
	}
}
























