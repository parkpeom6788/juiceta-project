package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.vo.ProductVO;

public interface ProductService {

	List<ProductVO> findProductAllList();
	
	void registerProduct(ProductVO productVO);

}