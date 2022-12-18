package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.ShopPagination;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	@Override
	public Map<String, Object> findProductAllList(String pageNo){
		int totalProductCount = productMapper.getTotalProductCount();
		ShopPagination shopPagination = null;
		if(pageNo==null)
			shopPagination = new ShopPagination(totalProductCount);
		else
			shopPagination = new ShopPagination(Integer.parseInt(pageNo), totalProductCount);
		
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", productMapper.findProductAllList(shopPagination));
		paging.put("PAGINATION", shopPagination);
		
		return paging;
	}

	@Override
	public ProductVO findProductByProductNo(int productNo) {
		return productMapper.findProductByProductNo(productNo);
	}
	
	@Override
	public void registerProduct(ProductVO productVO) {

	}

	
}




















