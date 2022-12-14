package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final ProductService productService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("productAllList", productService.findProductAllList());
		return "index";
	}
}


















