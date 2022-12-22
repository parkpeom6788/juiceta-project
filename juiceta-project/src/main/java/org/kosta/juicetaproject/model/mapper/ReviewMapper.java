package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.ReviewVO;

@Mapper
public interface ReviewMapper {

	void registerReview(ReviewVO reviewVO);

	List<ReviewVO> findReviewListByProductNo(int productNo);


}
