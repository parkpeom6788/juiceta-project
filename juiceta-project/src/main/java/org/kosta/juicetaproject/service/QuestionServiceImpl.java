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
	
	// questionDetail(in questionNo:int): QuestionVO
	// 글 상세
	public QuestionVO questionDetail(int questionNo) {
		QuestionVO questionVO= questionmapper.questionDetail(questionNo);
		return questionVO;
	}
	// 게시물 작성 
	@Override
	public void registerQuestion(String questionTitle,String questionContent,int productNo,String id) {
			questionmapper.registerQuestion(questionTitle,questionContent,productNo,id);
	}
	// 답변 등록
	@Override
	public void registerAnswer(AnswerVO answerVO) {
		questionmapper.registerAnswer(answerVO);
	}
	
	// findAnswerByQuestionNo(in questionNo:int): AnswerVO
	// 답변 여부 -> 
	public AnswerVO findAnswerByQuestionNo(int questionNo) {
		AnswerVO answerVO = (AnswerVO) questionmapper.findAnswerByQuestionNo(questionNo);
		return answerVO;
	}
	// updateQuestion(in questionVO:QuestionVO)
	// 수정 -> 답변여부를 0에서1로 바꿈
	public void updateQuestion(int questionNo) {
		questionmapper.updateQuestion(questionNo);
	}
	// deleteReview(in id:String, in questionNo:int)
	// 삭제
	public void deleteReview(String id, int questionNo) {
	}
}
