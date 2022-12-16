package org.kosta.juicetaproject.service;

import java.util.List;
import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
	public List<QuestionVO> findQuestionAllListByProductNo(int productNo);
	public QuestionVO questionDetail(int questionNo);
	public void registerQuestion();
	public void updateQuestion(QuestionVO questionVO);
	public void deleteReview(String id, int questionNo);
	public AnswerVO registerAnswer();
	public AnswerVO findAnswerByQuestionNo(int questionNo);
}