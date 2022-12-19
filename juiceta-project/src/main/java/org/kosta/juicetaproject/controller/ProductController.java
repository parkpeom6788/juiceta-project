package org.kosta.juicetaproject.controller;

import java.util.List;

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
	private final ProductService productService;
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
	public String productAdmin(Model model,String productKeyword) {
		List<ProductVO> list=null;
		if(productKeyword == null) {
			list=productService.productAllListByRnum();
		}else {
			list=productService.findProductListByKeyword(productKeyword);
		}
		model.addAttribute("productList", list);
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
	
}






