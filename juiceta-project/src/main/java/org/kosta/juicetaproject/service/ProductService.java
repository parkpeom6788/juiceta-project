package org.kosta.juicetaproject.service;

import java.util.Map;

import org.kosta.juicetaproject.model.vo.ProductVO;

public interface ProductService {

	Map<String, Object> findProductAllList(String pageNo);
	
	void registerProduct(ProductVO productVO);

	ProductVO findProductByProductNo(int productNo);

}