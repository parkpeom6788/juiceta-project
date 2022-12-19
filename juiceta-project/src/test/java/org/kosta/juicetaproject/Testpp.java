package org.kosta.juicetaproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.QuestionMapper;
import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testpp {
	
	private final QuestionMapper questionMapper;
	
	@Autowired
	public Testpp(QuestionMapper questionMapper) {
		super();
		this.questionMapper = questionMapper;
	}
	
	// findQuestionAllListByProductNo(in productNo:int): List
	// 문의사항 목록 조회
	@Test
	public void findQuestionAllListByProductNo() {
		// findQuestionAllListByProductNo(in productNo:int): List
		// in productNo:int): List
		int productNo = 1;
		List<QuestionVO> list = questionMapper.findQuestionAllListByProductNo(productNo);
		System.out.println(list);
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	// 게시물 상세 조회
	@Test
	public void questionDetail() {
		int productNo = 1;
		QuestionVO questionVO= questionMapper.questionDetail(productNo);
		System.out.println(questionVO);
	}
	
	// 문의사항 등록
		@Test
		public void registerQuestion() {
			//INSERT INTO juiceta_question(QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER ,
			//PRODUCT_NO,id) VALUES(2,'제목입니다2','문의사항 입니다2','2022-12-18',0,64,'pjs');
			String id = "jtest";
			QuestionVO questionVO = new QuestionVO("제목입니다","문의사항입니다2",64,id);
			questionMapper.registerQuestion(questionVO);
		}
		
	// 답변 수정
	@Test
	public void updateQuestion() {
		int productNo = 1;
		QuestionVO questionVO= questionMapper.questionDetail(productNo);
		System.out.println(questionVO);
	}
	
	// 답변 삭제 
	@Test
	public void deleteReview() {
		int productNo = 1;
		QuestionVO questionVO= questionMapper.questionDetail(productNo);
		System.out.println(questionVO);
	}
	
	// 답변 등록 - 테스트 완료 
	@Test
	public void registerAnswer() {
		QuestionVO questionVO = new QuestionVO(1,"","","",0,1,"");
		
	}
	
	// 답변 여부
	@Test
	public void findAnswerByQuestionNo() {
		int productNo = 1;
		AnswerVO answerVO = questionMapper.findAnswerByQuestionNo(productNo);
		System.out.println(answerVO);
	}
}


