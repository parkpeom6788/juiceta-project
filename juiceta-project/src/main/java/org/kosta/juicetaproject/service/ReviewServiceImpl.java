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

	@Override
	public int findCountByCheckReview(int orderNo, int productNo) {
		return reviewMapper.findCountByCheckReview(orderNo, productNo);
	}
	
	public int reviewCheck(int orderNo, int productNo) {
		int check = reviewMapper.reviewCheck(orderNo, productNo);
		return check;
	}
	
	@Override
	public int avgStarByProductNo(int productNo) {
		int avgStar = 0;
		List<ReviewVO> list = reviewMapper.findReviewListByProductNo(productNo);
		if(list.size()!=0) {
			avgStar = reviewMapper.avgStarByProductNo(productNo);
		}
		return avgStar;
	}

	@Override
	public List<ReviewVO> getAllReviewList(String id) {
		return reviewMapper.getAllReviewList(id);
	}

	@Override
	public int updateReview(ReviewVO reviewVO) {
		return reviewMapper.updateReview(reviewVO);
	}

	@Override
	public int deleteReview(int reviewNo) {
		return reviewMapper.deleteReview(reviewNo);
	}

}
