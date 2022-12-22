package org.kosta.juicetaproject.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.Pagination;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	@Override
	public Map<String, Object> findProductAllList(String pageNo){
		int totalProductCount = productMapper.getTotalProductCount();
		Pagination pagination = null;
		if(pageNo==null)
			pagination = new Pagination(totalProductCount);
		else
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);
		
		pagination.setPostCountPerPage(8);
		
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", productMapper.findShopProductAllList(pagination));
		
		if(totalProductCount==0)
			pagination = null;
		
		paging.put("PAGINATION", pagination);
		
		return paging;
	}

	@Override
	public ProductVO findProductByProductNo(int productNo) {
		return productMapper.findProductByProductNo(productNo);
	}
	
	@Override
	public void registerProduct(ProductVO productVO,MultipartFile file) throws Exception {
        String projectpath = System.getProperty("user.dir")+"/src/main/resources/static/images"; 
        /* UUID uuid = UUID.randomUUID(); */
       String filename=file.getOriginalFilename(); 
       File saveFile = new File(projectpath, filename); 
       file.transferTo(saveFile);
       productVO.setImage(filename);
       productVO.setFilePath("images/"+filename);
       productMapper.registerProduct(productVO);
	}
	
	@Override
	public Map<String, Object> findProductAllListByCategory(String category, String pageNo) {
		int totalProductCount = productMapper.getTotalProductCountbyCategory(category);
		Pagination pagination = null;
		if(pageNo==null)
			pagination = new Pagination(totalProductCount);
		else
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);
		
		pagination.setPostCountPerPage(8);
		
		Map<String, Object> map = new HashMap<>();
		map.put("PAGINATION", pagination);
		map.put("CATEGORY", category);
		
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", productMapper.findProductAllListByCategory(map));
		
		if(totalProductCount==0)
			pagination = null;
		
		paging.put("PAGINATION", pagination);
		
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
		
		if(totalCount==0)
			pagination = null;
		
		paging.put("PAGINATION", pagination);
		return paging;
	}

	@Override
	public Map<String, Object> findProductListByKeyword(String productKeyword,String pageNo) {
		int totalProductCount =productMapper.findCountProductByKeyword(productKeyword);
		Pagination pagination = null;	
		if(pageNo=="")
			pagination = new Pagination(totalProductCount);
		else {
			pagination = new Pagination(Integer.parseInt(pageNo), totalProductCount);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("PAGINATION", pagination);
		map.put("KEYWORD",productKeyword);
		
		Map<String, Object> paging =new HashMap<>();
		paging.put("LIST", productMapper.findProductListByKeyword(map));
		
		if(totalProductCount==0)
			pagination = null;
		
		paging.put("PAGINATION", pagination);
		return paging;
	}

	@Override
	public List<ProductVO> findAllProduct(Pagination pagination) {
		return productMapper.findAllProduct(pagination);
	}

	@Override
	public int findCountProductByKeyword(String keyword) {
		return productMapper.findCountProductByKeyword(keyword);
	}

}
