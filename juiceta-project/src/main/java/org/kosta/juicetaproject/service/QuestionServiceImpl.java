package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.QuestionMapper;
import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
	
	private final QuestionMapper questionmapper;
	
	// 리스트 출력 
	public List<QuestionVO> findQuestionAllListByProductNo(int productNo) {
		return questionmapper.findQuestionAllListByProductNo(productNo);
	}
	
	//questionDetail(in questionNo:int): QuestionVO
	// 삭제 
	public QuestionVO questionDetail(int questionNo) {
		return null;
	}
	
	// registerQuestion(in questionVO:QuestionVO)
	// 등록
	public void registerQuestion() {
	}
	
	// updateQuestion(in questionVO:QuestionVO)
	// 수정
	public void updateQuestion(QuestionVO questionVO) {
	}
	
	// deleteReview(in id:String, in questionNo:int)
	// 삭제
	public void deleteReview(String id, int questionNo) {
	}
	
	// registerAnswer(in answerVO:AnswerVO)
	// 답변 등록
	public AnswerVO registerAnswer() {
		return null;
	}
	
	// findAnswerByQuestionNo(in questionNo:int): AnswerVO
	// 답변 여부 
	public AnswerVO findAnswerByQuestionNo(int questionNo) {
		return null;
	}
}
