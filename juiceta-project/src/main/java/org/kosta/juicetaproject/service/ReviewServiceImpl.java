package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.ReviewMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderDetailVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.ReviewVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewMapper reviewMapper;

	@Override
	public List<ReviewVO> findReviewListByProductNo(int productNo) {
		return reviewMapper.findReviewListByProductNo(productNo);
	}

	@Override
	public Map<String, String> findOrderInfoForReviewByOrderNoAndProductNo(int orderNo, int productNo) {
		Map<String, String> orderInfo = new HashMap<>();
		orderInfo.put("PRODUCT_NAME", reviewMapper.findProductNameForReviewByProductNo(productNo));
		orderInfo.put("ORDER_TIME", reviewMapper.findOrderTimeForReviewByOrderNo(orderNo));
		return orderInfo;
	}

	@Override
	public void registerReview(MemberVO memberVO, ReviewVO reviewVO, String orderNo, String productNo) {
		reviewVO.setMemberVO(memberVO);
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderNo(Integer.parseInt(orderNo));
		ProductVO productVO = new ProductVO();
		productVO.setProductNo(Integer.parseInt(productNo));
		OrderDetailVO orderDetailVO = new OrderDetailVO();
		orderDetailVO.setOrderVO(orderVO);
		orderDetailVO.setProductVO(productVO);
		reviewVO.setOrderDetailVO(orderDetailVO);
		reviewMapper.registerReview(reviewVO);
	}

}










