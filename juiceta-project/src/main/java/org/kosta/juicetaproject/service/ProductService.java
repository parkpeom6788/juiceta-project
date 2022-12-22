package org.kosta.juicetaproject.service;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.Pagination;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

	Map<String, Object> findProductAllList(String pageNo);
	
	void registerProduct(ProductVO productVO,MultipartFile file) throws Exception;

	ProductVO findProductByProductNo(int productNo);
	
	int updateProduct(ProductVO productVO);
	
	int deleteProduct(int productNo);
	
	Map<String,Object> productAllListByRnum(String pageNo);
	
	Map<String, Object> findProductAllListByCategory(String category, String pageNo);

	List<ProductVO> findProductByProductNameKeyword(String searchKeyword);

	Map<String, Object> findProductListByKeyword(String keyword,String pageNo);
	
	List<ProductVO> findAllProduct(Pagination pagination);
	
	int findCountProductByKeyword(String keyword);
}