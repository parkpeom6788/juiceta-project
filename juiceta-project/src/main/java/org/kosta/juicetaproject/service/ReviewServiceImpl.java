package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.ReviewMapper;
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

}
