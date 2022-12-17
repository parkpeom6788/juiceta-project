package org.kosta.juicetaproject.controller;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.kosta.juicetaproject.service.ProductService;
import org.kosta.juicetaproject.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Data
public class ProductController {
	private final ProductMapper productMapper;
	private final QuestionService QuestionService;
	private final ProductService productService;
	
	@RequestMapping("/guest/DetailView")
	public String productDetail(int productNo,Model model) {
		// 상품상세정보
		ProductVO productVO = productService.findProductByProductNo(productNo);
		model.addAttribute("productVO", productVO);
		
		// 문의사항 게시판
		List<QuestionVO> questionAllList= QuestionService.findQuestionAllListByProductNo(productNo);
		model.addAttribute("questionAllList", questionAllList);
		return "product/product-detail";
	}
	
	@RequestMapping("productAdmin")
	public String productAdmin(Model model) {
		model.addAttribute("productVO",productMapper.findProductAllList());
		return "product/product-list";
	}
	
	@RequestMapping("registerProductForm")
	public String registerProductForm() {
		return "product/register-form";
	}
	
	@RequestMapping("updateProductForm")
	public String updateProductForm() {
		return "product/update-form";
	}
	
	@PostMapping("updateProduct")
	public String updateProduct() {
		return "redirect:update";
	}
	
	@RequestMapping("shop")
	public String shop() {
		return "product/shop";
	}
}






