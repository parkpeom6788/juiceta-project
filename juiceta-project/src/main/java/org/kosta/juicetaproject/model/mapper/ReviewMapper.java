package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.ReviewVO;

@Mapper
public interface ReviewMapper {

	void registerReview(ReviewVO reviewVO);

	List<ReviewVO> findReviewListByProductNo(int productNo);

	String findProductNameForReviewByProductNo(int productNo);

	String findOrderTimeForReviewByOrderNo(int orderNo);

	int findCountByCheckReview(int orderNo, int productNo);

	int reviewCheck(int orderNo, int productNo);

	int avgStarByProductNo(int productNo);


}
