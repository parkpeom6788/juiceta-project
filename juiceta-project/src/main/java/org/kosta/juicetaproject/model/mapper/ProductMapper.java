package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.ShopPagination;

@Mapper
public interface ProductMapper {

	int getTotalProductCount();

	List<ProductVO> findProductAllList(ShopPagination shopPagination);
	
	ProductVO findProductByProductNo(int productNo);


}
