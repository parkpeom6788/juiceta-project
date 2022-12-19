package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.CartAndWishlistMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
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
	
}























