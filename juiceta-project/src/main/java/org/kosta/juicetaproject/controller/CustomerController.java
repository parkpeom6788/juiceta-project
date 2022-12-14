package org.kosta.juicetaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	@RequestMapping("customerLogin")
		public String customerLogin() {
			return "customer/login-form";
	}
}
