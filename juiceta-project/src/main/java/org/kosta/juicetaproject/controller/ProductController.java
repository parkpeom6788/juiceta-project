package org.kosta.juicetaproject.controller;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.kosta.juicetaproject.model.vo.ReviewVO;
import org.kosta.juicetaproject.service.ProductService;
import org.kosta.juicetaproject.service.QuestionService;
import org.kosta.juicetaproject.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final QuestionService QuestionService;
	private final ReviewService reviewService;
	
	// 상품 상세 페이지로 이동 
	@RequestMapping("/guest/DetailView")
	public String productDetail(int productNo,Model model) {
		// 상품상세정보
		ProductVO productVO = productService.findProductByProductNo(productNo);
		model.addAttribute("productVO", productVO);
		
		// 상품후기
		List<ReviewVO> reviewList = reviewService.findReviewListByProductNo(productNo);
		model.addAttribute("reviewList", reviewList);
		
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
	public String productAdmin(Model model,String pageNo) {
		Map<String, Object> paging = productService.productAllListByRnum(pageNo);
		model.addAttribute("productList", paging.get("LIST"));
		model.addAttribute("pagination", paging.get("PAGINATION"));
		return "product/product-list";
	}
	
	
	
	// 상품관리 검색
	@RequestMapping("productSelect")
	public String findProductListByKeyword(String productKeyword, String pageNo,Model model) {
		if(pageNo==null) {
			pageNo="1";
		}
		if(productKeyword=="") {
			Map<String, Object> paging = productService.productAllListByRnum(pageNo);
			model.addAttribute("productList", paging.get("LIST"));
			model.addAttribute("pagination", paging.get("PAGINATION"));
			return "product/product-list";
		}
		Map<String, Object> paging=productService.findProductListByKeyword(productKeyword,pageNo);
		model.addAttribute("productList", paging.get("LIST"));
		model.addAttribute("pagination", paging.get("PAGINATION"));
		return "product/product-list";
	}
	
	
	
	// 상품등록 폼 제공
	@RequestMapping("registerProductForm")
	public String registerProductForm() {
		return "product/register-form";
	}
	// 상품등록
	@PostMapping("registerProduct")
	public String registerProduct(ProductVO productVO,MultipartFile file) throws Exception {
		productService.registerProduct(productVO,file);
		return "redirect:registerProductResult";
	}
	// 상품등록 후 결과
	@RequestMapping("registerProductResult")
	public String registerProductResult() {
		return "product/register-result";
	}
	// 상품수정 폼 제공
	@RequestMapping("updateProductForm")
	public String updateProductForm(Model model, int productNo) {
		model.addAttribute("productVO",productService.findProductByProductNo(productNo));
		return "product/update-form";
	}
	// 상품수정
	@PostMapping("update")
	public String updateProduct(ProductVO productVO) {
		productService.updateProduct(productVO);
		return "redirect:updateProductResult";
	}
	
	/*
	 * @PostMapping("updateProduct") public String updateProduct() { return
	 * "redirect:update"; }
	 */
	// 상품수정 후 결과
	@RequestMapping("updateProductResult")
	public String updateResult() {
		return "/product/update-result";
	}
	// 상품삭제
	@PostMapping("deleteProduct")
	public String deleteProduct(int productNo) {
		productService.deleteProduct(productNo);
		return "redirect:deleteResult";
	}
	// 상품삭제 후 결과 
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
		return "product/shop-"+(category.equals("juice")?"juice":"tea");
	}
	
	@RequestMapping("/guest/findProductByProductNameKeyword")
	public String findProductByProductNameKeyword(String searchKeyword, Model model) {
		model.addAttribute("productList", productService.findProductByProductNameKeyword(searchKeyword));
		return "product/product-search-keyword";
	}
}






