package org.kosta.juicetaproject.controller;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.QuestionVO;
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
	
	// 상품 상세 페이지로 이동 
	@RequestMapping("/guest/DetailView")
	public String productDetail(int productNo,Model model) {
		List<QuestionVO> questionAllList= QuestionService.findQuestionAllListByProductNo(productNo);
		model.addAttribute("questionAllList", questionAllList);
		model.addAttribute("productNo", productNo);
		return "product/product-detail";
	}
	// 글 작성 
	@RequestMapping("/guest/registerProductForm")
	public String registerProductForm() {
		return "product/register-form";
	}
	// 글 상세 페이지
	//questionDetail(in questionNo:int): QuestionVO
	@RequestMapping("/guest/Detail")
	public String questionDetail(int productNo,Model model) {
		model.addAttribute("productNo", productNo);
		return "/guest/Detail";
	}
	@RequestMapping("productAdmin")
	public String productAdmin(Model model) {
		model.addAttribute("productVO",productMapper.findProductAllList());
		return "product/product-list";
	}
	@RequestMapping("updateProductForm")
	public String updateProductForm() {
		return "product/update-form";
	}
	@PostMapping("updateProduct")
	public String updateProduct() {
		return "redirect:update";
	}
}






