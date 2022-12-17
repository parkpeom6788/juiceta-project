package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	@Override
	public List<ProductVO> findProductAllList(){
		return productMapper.findProductAllList();
	}

	@Override
	public ProductVO findProductByProductNo(int productNo) {
		return productMapper.findProductByProductNo(productNo);
	}
	
	@Override
	public void registerProduct(ProductVO productVO) {

	}

	
}




















