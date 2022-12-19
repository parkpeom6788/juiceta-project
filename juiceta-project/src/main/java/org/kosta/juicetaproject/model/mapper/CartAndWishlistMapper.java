package org.kosta.juicetaproject.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartAndWishlistMapper {

	int findWishlistByIdAndProductNo(Map<String, Object> map);

	void addWishlist(Map<String, Object> map);

	int findCartByIdAndProductNo(Map<String, Object> map);

	void addCart(Map<String, Object> map);

	int getTotalCartById(String id);

}
