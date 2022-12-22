package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.vo.ReviewVO;

public interface ReviewService {

	List<ReviewVO> findReviewListByProductNo(int productNo);

}
