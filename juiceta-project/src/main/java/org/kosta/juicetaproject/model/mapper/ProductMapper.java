package org.kosta.juicetaproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.Pagination;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.ShopPagination;

@Mapper
public interface ProductMapper {

	int getTotalProductCount();
	
	List<ProductVO> findShopProductAllList(ShopPagination shopPagination);
	
	ProductVO findProductByProductNo(int productNo);
	
	int updateProduct(ProductVO productVO);

	int registerProduct(ProductVO productVO);

	int deleteProduct(int productNo);

	List<ProductVO> productAllListByRnum ();

	List<ProductVO> findProductListByKeyword(String keyword);

	List<ProductVO> findProductAllListByCategory(Map<String, Object> map);

	int getTotalProductCountbyCategory(String category);

	List<ProductVO> findProductByProductNameKeyword(String keyword);

	List<ProductVO> findAllProduct(Pagination pagination);

}
