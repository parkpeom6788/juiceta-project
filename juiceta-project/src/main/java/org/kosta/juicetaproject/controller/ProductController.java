package org.kosta.juicetaproject.controller;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.kosta.juicetaproject.service.ProductService;
import org.kosta.juicetaproject.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final QuestionService QuestionService;
	
	// 상품 상세 페이지로 이동 
	@RequestMapping("/guest/DetailView")
	public String productDetail(int productNo,Model model) {
		// 상품상세정보
		ProductVO productVO = productService.findProductByProductNo(productNo);
		model.addAttribute("productVO", productVO);
		
		// 문의사항 게시판
		List<QuestionVO> questionAllList= QuestionService.findQuestionAllListByProductNo(productNo);
		model.addAttribute("questionAllList", questionAllList);
		model.addAttribute("productNo", productNo);
		return "product/product-detail";
	}

	// 글 상세 페이지
	//questionDetail(in questionNo:int): QuestionVO
	@RequestMapping("/guest/Detail")
	public String questionDetail(int productNo,Model model) {
		model.addAttribute("productNo", productNo);
		return "/guest/Detail";
	}
	
	
	// 상품관리 전체 리스트 조회
	@RequestMapping("productAdmin")
	public String productAdmin(Model model,String productNo) {
		model.addAttribute("productList", productService.productAllListByRnum(productNo));
		return "product/product-list";
	}
	
	
	
	// 상품관리 검색
	@RequestMapping("productSelect")
	public String findProductListByKeyword(String productKeyword, Model model) {
		model.addAttribute("productList", productService.findProductListByKeyword(productKeyword));
		return "product/product-list";
	}
	
	
	
	
	@RequestMapping("registerProductForm")
	public String registerProductForm() {
		return "product/register-form";
	}

	@PostMapping("registerProduct")
	public String registerProduct(ProductVO productVO) {
		productService.registerProduct(productVO);
		return "redirect:registerProductResult?";
	}
	
	@RequestMapping("registerProductResult")
	public String registerProductResult() {
		return "product/register-result";
	}

	@RequestMapping("updateProductForm")
	public String updateProductForm(Model model, int productNo) {
		model.addAttribute("productVO",productService.findProductByProductNo(productNo));
		return "product/update-form";
	}

	@PostMapping("update")
	public String updateProduct(ProductVO productVO) {
		productService.updateProduct(productVO);
		return "redirect:updateProductResult";
	}
	
	@PostMapping("updateProduct")
	public String updateProduct() {
		return "redirect:update";
	}

	@RequestMapping("updateProductResult")
	public String updateResult() {
		return "/product/update-result";
	}
	
	@PostMapping("deleteProduct")
	public String deleteProduct(int productNo) {
		productService.deleteProduct(productNo);
		return "redirect:deleteResult";
	}
	
	@RequestMapping("deleteResult")
	public String deleteResult() {
		return "product/delete-result";
	}
	
	@RequestMapping("shop")
	public String shop(String pageNo, Model model) {
		Map<String, Object> paging = productService.findProductAllList(pageNo);
		model.addAttribute("productAllList", paging.get("LIST"));
		model.addAttribute("pagination", paging.get("PAGINATION"));
		return "product/shop";
	}
	
	@RequestMapping("shopCategory")
	public String shopCategory(String category, String pageNo, Model model) {
		Map<String, Object> paging = productService.findProductAllListByCategory(category, pageNo);
		model.addAttribute("productAllList", paging.get("LIST"));
		model.addAttribute("pagination", paging.get("PAGINATION"));
		return "product/shop-"+(category.equals("Juice")?"juice":"tea");
	}
	
	@RequestMapping("/guest/findProductByProductNameKeyword")
	public String findProductByProductNameKeyword(String searchKeyword, Model model) {
		model.addAttribute("productList", productService.findProductByProductNameKeyword(searchKeyword));
		return "product/product-search-keyword";
	}

}






