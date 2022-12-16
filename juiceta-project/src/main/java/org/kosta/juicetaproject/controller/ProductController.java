package org.kosta.juicetaproject.controller;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.ProductVO;
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
	
	@RequestMapping("/guest/DetailView")
	public String productDetail(int productNo,Model model) {
		System.out.println(productNo);
		
		List<QuestionVO> questionAllList= QuestionService.findQuestionAllListByProductNo(productNo);
		
		for(int i=0; i< questionAllList.size(); i++) {
			System.out.println(questionAllList.get(i));
	}
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
	public String updateProductForm(Model model, int productNo) {
		System.out.println(productNo);
		model.addAttribute("productVO",productMapper.findProductByProductNo(productNo));
		return "product/update-form";
	}
	@PostMapping("update")
	public String updateProduct(ProductVO productVO) {
		System.out.println(1);
		productMapper.updateProduct(productVO);
		return "redirect:updateProductResult";
	}
	@RequestMapping("updateProductResult")
	public String updateResult() {
		return "/product/update-result";
	}
}






