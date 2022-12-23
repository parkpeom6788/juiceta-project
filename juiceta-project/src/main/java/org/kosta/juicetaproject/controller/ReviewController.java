package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ReviewVO;
import org.kosta.juicetaproject.service.OrderService;
import org.kosta.juicetaproject.service.ReviewService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService reviewService;
	
	@RequestMapping("registerReviewForm")
	public String registerReview(int orderNo, int productNo, Model model) {
		int check = reviewService.reviewCheck(orderNo, productNo);
		if(check>=1) {
			
			return "order/reviewCheckResultForm?orderNo="+orderNo;
		}
		model.addAttribute("orderInfo", reviewService.findOrderInfoForReviewByOrderNoAndProductNo(orderNo, productNo));
		return "order/register-review-form";
	}
	
	@PostMapping("registerReview")
	public String registerReview(@AuthenticationPrincipal MemberVO memberVO, ReviewVO reviewVO, String orderNo, String productNo) {
		reviewService.registerReview(memberVO,reviewVO,orderNo,productNo);
		return "redirect:registerReviewResult";
	}
	
	@RequestMapping("registerReviewResult")
	public String registerReviewResult() {
		return "order/register-review-result";
	}

}






