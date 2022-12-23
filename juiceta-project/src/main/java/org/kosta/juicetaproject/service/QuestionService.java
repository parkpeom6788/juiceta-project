package org.kosta.juicetaproject.service;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
	public List<QuestionVO> findQuestionAllListByProductNo(int productNo);
	// 상세 게시물
	public QuestionVO questionDetail(int questionNo);
	// 등록
	public void registerQuestion(String questionTitle,String questionContent,int productNo,String id);
	// 수정
	// 답변 0->1
	public void updateQuestion(int questionNo);
	// 삭제
	public void deleteReview(String id, int questionNo);
	// 답변등록 
	public void registerAnswer(AnswerVO answerVO);
	
	public AnswerVO findAnswerByQuestionNo(int questionNo);
	
	
}