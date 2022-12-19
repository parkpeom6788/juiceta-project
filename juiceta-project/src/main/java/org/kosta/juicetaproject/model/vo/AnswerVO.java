package org.kosta.juicetaproject.model.vo;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RequestMapping
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerVO {
	private int questionNo;
	private String answerContent;
	private String answerTime;
	private QuestionVO questionVO;
	
	// 답변등록
	public AnswerVO(int questionNo , String answerContent) {
		this.questionNo = questionNo;
		this.answerContent = answerContent;
	}
	
	public AnswerVO(String answerContent, String answerTime, QuestionVO questionVO) {
		super();
		this.answerContent = answerContent;
		this.answerTime = answerTime;
		this.questionVO = questionVO;
	}
}
