package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.QuestionVO;

@Mapper
public interface QuestionMapper {

	// 등록 Q&A 
	void registerQuestion(QuestionVO questionVO);

	List<QuestionVO> findQuestionAllListByProductNo(int productNo);
}
