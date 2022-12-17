package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.ProductVO;

@Mapper
public interface ProductMapper {

	List<ProductVO> findProductAllList();
	
	ProductVO findProductByProductNo(int productNo);

}
