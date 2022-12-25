package org.kosta.juicetaproject.service;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ReviewVO;

public interface ReviewService {

	List<ReviewVO> findReviewListByProductNo(int productNo);

	Map<String, String> findOrderInfoForReviewByOrderNoAndProductNo(int orderNo, int productNo);

	void registerReview(MemberVO memberVO, ReviewVO reviewVO, String orderNo, String productNo);
	
	int findCountByCheckReview(int orderNo, int productNo);

	int reviewCheck(int orderNo, int productNo);

	int avgStarByProductNo(int productNo);

	List<ReviewVO> getAllReviewList(String id);

	int updateReview(ReviewVO reviewVO);

	int deleteReview(int reviewNo);

}
