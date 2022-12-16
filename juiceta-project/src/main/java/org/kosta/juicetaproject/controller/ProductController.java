package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	@RequestMapping("productDetailView")
	public String productDetail(int productNo,Model model) {
		model.addAttribute("productDetail", productService.productDetail(productNo));
		return "product/product-detail";
	}
}
