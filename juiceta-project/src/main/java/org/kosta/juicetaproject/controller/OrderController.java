package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.service.OrderService;
import org.kosta.juicetaproject.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class OrderController {
	private final ProductService productService;
	private final OrderService orderService;
	
	@RequestMapping("checkoutForm")
	public String checkoutForm(int productNo, int productCount, Model model) {
		ProductVO productVO = productService.findProductByProductNo(productNo);
		model.addAttribute("totalPrice", productVO.getPrice()*productCount);
		return "order/checkout-form-single";
	}
	
	@RequestMapping("checkoutFormFromCart")
	public String checkoutFormFromCart(String productNo,String productCount, int cartTotal) {
		return "order/checkout-form-cart";
	}

	@RequestMapping("orderDetail")
	public String orderDetail(Model model,int orderNo) {
		model.addAttribute("orderInfo", orderService.findOrderInfoByOrderNo(orderNo));
		model.addAttribute("list", orderService.findOrderTotalPriceInfoByOrderNo(orderNo));
		return "order/order-detail";
	}
	
	@PostMapping("placeAnOrder")
	public String placeAnOrder(@AuthenticationPrincipal MemberVO memberVO, String name, String phone, String address, int productNo, int productCount) {
		OrderVO orderVO = OrderVO.builder().receiverName(name).receiverPhone(phone).receiverAddress(address).build();
		int orderNo = orderService.placeAnOrder(memberVO,orderVO,productNo,productCount);
		System.out.println(orderVO);
		return "redirect:placeAnOrderResult?orderNo="+orderNo;
	}
	
	@RequestMapping("placeAnOrderResult")
	public String placeAnOrderResult(int orderNo, Model model) {
		model.addAttribute("orderVO", orderService.findOrderByOrderNo(orderNo));
		return "order/checkoutResult";
	}
	
	@RequestMapping("checkoutResult")
	public String checkoutForm2Result() {
		return "order/checkoutResult";
	}

	@PostMapping("placeAnOrderFromCart")
	public String placeAnOrderFromCart(@AuthenticationPrincipal MemberVO memberVO, String name, String phone, String address, String productNo, String productCount) {
		OrderVO orderVO = OrderVO.builder().receiverName(name).receiverPhone(phone).receiverAddress(address).build();
		int orderNo = orderService.placeAnOrderFromCart(memberVO,orderVO,productNo,productCount);
		return "redirect:placeAnOrderResult?orderNo="+orderNo;
	}

}

















