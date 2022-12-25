package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVO {
	private int questionNo;
	private String questionTitle;
	private String questionContent;
	private String questionTime;
	private int checkAnswer;
	private MemberVO memberVO;
	private ProductVO productVO;
	private int productNo;
	private String id;
	
	// 글 등록 
	public QuestionVO(int questionNo, String questionTitle, String questionContent, String questionTime,
			int checkAnswer,int productNo , String id) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionTime = questionTime;
		this.checkAnswer = checkAnswer;
		this.productNo = productNo;
		this.id = id;
	}

	public QuestionVO(String questionTitle, String questionContent,String questionTime,int productNo, String id) {
		super();
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionTime = questionTitle;
		this.productNo = productNo;
		this.id = id;
	}

	public QuestionVO(String questionTitle, String questionContent, int productNo, String id) {
		super();
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.productNo = productNo;
		this.id = id;
	}
}
