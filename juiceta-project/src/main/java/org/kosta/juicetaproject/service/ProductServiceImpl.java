package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.Pagination;
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
		paging.put("LIST", productMapper.findShopProductAllList(shopPagination));
		paging.put("PAGINATION", shopPagination);
		
		return paging;
	}

	@Override
	public ProductVO findProductByProductNo(int productNo) {
		return productMapper.findProductByProductNo(productNo);
	}
	
	@Override
	public int registerProduct(ProductVO productVO) {
		return productMapper.registerProduct(productVO);
	}
	
	@Override
	public Map<String, Object> findProductAllListByCategory(String category, String pageNo) {
		int totalProductCount = productMapper.getTotalProductCountbyCategory(category);
		ShopPagination shopPagination = null;
		if(pageNo==null)
			shopPagination = new ShopPagination(totalProductCount);
		else
			shopPagination = new ShopPagination(Integer.parseInt(pageNo), totalProductCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("PAGINATION", shopPagination);
		map.put("CATEGORY", category);
		
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", productMapper.findProductAllListByCategory(map));
		paging.put("PAGINATION", shopPagination);
		
		return paging;
	}

	@Override
	public List<ProductVO> findProductByProductNameKeyword(String searchKeyword) {
		return productMapper.findProductByProductNameKeyword(searchKeyword);
	}
	
	@Override
	public int updateProduct(ProductVO productVO) {
		return productMapper.updateProduct(productVO);
	}

	@Override
	public int deleteProduct(int productNo) {
		return productMapper.deleteProduct(productNo);
	}

	@Override
	public Map<String, Object> productAllListByRnum(String pageNo) {
		int totalCount = productMapper.getTotalProductCount();
		Pagination pagination = null;
		if(pageNo==null)
			pagination=new Pagination(totalCount);
		else {
			pagination=new Pagination(Integer.parseInt(pageNo), totalCount);
		}
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", productMapper.findAllProduct(pagination));
		paging.put("PAGINATION", pagination);
		return paging;
	}

	@Override
	public Map<String, Object> findProductListByKeyword(String keyword,String pageNo) {
		int totalProductCount =productMapper.getTotalProductCount();
		Pagination pagination = null;
		
		if(pageNo=="")
			pagination = new Pagination(totalProductCount);
		else {
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("PAGINATION", pagination);
		map.put("KEYWORD",keyword);
		
		List<ProductVO> list = productMapper.findProductListByKeyword(map);
		Map<String, Object> paging =new HashMap<>();
		paging.put("LIST", list);
		paging.put("PAGINATION", pagination);
		return paging;
	}

	@Override
	public List<ProductVO> findAllProduct(Pagination pagination) {
		return productMapper.findAllProduct(pagination);
	}

}




















