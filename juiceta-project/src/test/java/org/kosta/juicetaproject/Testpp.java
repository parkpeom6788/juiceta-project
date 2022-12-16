package org.kosta.juicetaproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.QuestionMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.ProductVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest
class Testpp {
	private final QuestionMapper questionMapper;
	
	@Autowired
	public Testpp(QuestionMapper questionMapper) {
		super();
		this.questionMapper = questionMapper;
	}
	// 문의사항 등록
	@Test
	public void registerQuestion() {
		MemberVO memberVO = new MemberVO("pjs","a",null,null,null,null);
		ProductVO productVO = new ProductVO(1,null,0,0,null,null,null);
		QuestionVO questionVO = new QuestionVO(1,"제목입니다2","답변입니다2","2022-12-16",0,memberVO,productVO);
		questionMapper.registerQuestion(questionVO);
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
}


