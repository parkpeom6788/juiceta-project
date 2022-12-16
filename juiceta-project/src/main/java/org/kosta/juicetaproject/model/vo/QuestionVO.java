package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionVO {
	private int questionNo;
	private String questionTitle;
	private String questionContent;
	private String questionTime;
	private int checkAnswer;
	private MemberVO memberVO;
	private ProductVO productVO;
}
