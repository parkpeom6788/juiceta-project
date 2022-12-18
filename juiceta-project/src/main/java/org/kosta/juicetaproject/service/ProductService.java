package org.kosta.juicetaproject.service;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.ProductVO;

public interface ProductService {

	Map<String, Object> findProductAllList(String pageNo);
	
	void registerProduct(ProductVO productVO);

	ProductVO findProductByProductNo(int productNo);

	Map<String, Object> findProductAllListByCategory(String category, String pageNo);

	List<ProductVO> findProductByProductNameKeyword(String searchKeyword);

}