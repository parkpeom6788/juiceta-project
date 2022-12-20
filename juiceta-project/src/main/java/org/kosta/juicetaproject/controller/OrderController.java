package org.kosta.juicetaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@RequestMapping("checkoutForm")
	public String checkoutForm() {
		return "order/checkout";
	}
	@RequestMapping("orderDetail")
	public String orderDetail() {
		return "order/order-detail";
	}
}
