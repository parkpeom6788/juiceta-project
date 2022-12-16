package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductMapper productMapper;
	@RequestMapping("productDetailView")
	public String productDetail() {
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
}






