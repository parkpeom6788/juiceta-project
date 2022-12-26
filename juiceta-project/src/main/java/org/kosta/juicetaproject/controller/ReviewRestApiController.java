package org.kosta.juicetaproject.controller;

import java.util.List;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ReviewVO;
import org.kosta.juicetaproject.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReviewRestApiController {
	private final ReviewService reviewService;
	
	@GetMapping("reviews")
	public List<ReviewVO> getAllReviewListById(@AuthenticationPrincipal MemberVO memberVO, Model model){
		return reviewService.getAllReviewList(memberVO.getId());
	}
	
	@PutMapping("reviews")
	public ResponseEntity<String> updateReview(int reviewNo, String reviewContent, int star){
		int result = reviewService.updateReview(ReviewVO.builder().reviewNo(reviewNo).reviewContent(reviewContent).star(star).build());
		if(result==0)
			return ResponseEntity.notFound().build();
		return  ResponseEntity.ok().body(reviewNo+" 리뷰수정완료");
	}
	
	@DeleteMapping("reviews")
	public ResponseEntity<String> deleteReview(int reviewNo){
		int result = reviewService.deleteReview(reviewNo);
		if(result==0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(reviewNo+" 리뷰삭제완료");
	}

}
