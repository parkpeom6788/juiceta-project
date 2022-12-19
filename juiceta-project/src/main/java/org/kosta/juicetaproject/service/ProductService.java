package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.vo.ProductVO;

public interface ProductService {

	List<ProductVO> findProductAllList();
	
	int registerProduct(ProductVO productVO);

	ProductVO findProductByProductNo(int productNo);

	ProductVO productDetail(int productNo);
	
	int updateProduct(ProductVO productVO);
	
	int deleteProduct(int productNo);
	
	List<ProductVO> productAllListByRnum();
	
	List<ProductVO> findProductListByKeyword(String keyword);
	
}