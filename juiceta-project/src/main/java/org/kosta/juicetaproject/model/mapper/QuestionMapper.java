package org.kosta.juicetaproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;

@Mapper
public interface QuestionMapper {
	// 등록 Q&A 
	void registerQuestion(QuestionVO questionVO);

	// 게시물 전체 리스트 조회
	List<QuestionVO> findQuestionAllListByProductNo(int productNo);
	
	// 상세게시물
	QuestionVO questionDetail(int questionNo);
	
	// 관리자 답변 등록
	void registerAnswer(AnswerVO answerVO);

	// 게시물 작성
	void registerQuestion(String questionTitle, String questionContent,int productNo,String id);

	// 답변여부 
	AnswerVO findAnswerByQuestionNo(int questionNo);
	
	// 답변여부 0 -> 1 로 수정 
	void updateQuestion(int questionNo);

	// 상품에 대한 문의사항 개수 
	int findQuestionCountByProductNo(int productNo);

	// row number 페이징 네이션 처리
	List<QuestionVO> findQuestionByRowNumber(Map<String, Object> map);
}
