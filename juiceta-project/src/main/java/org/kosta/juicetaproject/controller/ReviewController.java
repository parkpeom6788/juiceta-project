package org.kosta.juicetaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	@RequestMapping("registerReview")
	public String registerReview() {
		return "order/register-review-form";
	}

}
