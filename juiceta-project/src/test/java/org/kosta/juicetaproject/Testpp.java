package org.kosta.juicetaproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.CartAndWishlistMapper;
import org.kosta.juicetaproject.model.mapper.QuestionMapper;
import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.Pagination;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testpp {
	private final QuestionMapper questionMapper;
	private final CartAndWishlistMapper cartAndWishlistMapper;
	
	@Autowired
	public Testpp(QuestionMapper questionMapper , CartAndWishlistMapper cartAndWishlistMapper) {
		super();
		this.questionMapper = questionMapper;
		this.cartAndWishlistMapper = cartAndWishlistMapper;
	}
	
	
	// 문의사항 등록
//	@Test
//	public void registerQuestion() {
//		MemberVO memberVO = new MemberVO("pjs","a",null,null,null,null);
//		ProductVO productVO = new ProductVO(1,null,0,0,null,null,null,0);
//		QuestionVO questionVO = new QuestionVO(1,"제목입니다2","답변입니다2","2022-12-16",0,memberVO,productVO);
//		questionMapper.registerQuestion(questionVO);
//	}

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
	// 게시물 상세 조회
	@Test
	public void questionDetail() {
		int productNo = 1;
		QuestionVO questionVO= questionMapper.questionDetail(productNo);
		System.out.println(questionVO);
	}
	// 문의사항 등록
	@Test
	public void registerQuestion() {
		//INSERT INTO juiceta_question(QUESTION_NO,QUESTION_TITLE,QUESTION_CONTENT,QUESTION_TIME , CHECK_ANSWER ,
		//PRODUCT_NO,id) VALUES(2,'제목입니다2','문의사항 입니다2','2022-12-18',0,64,'pjs');
		String id = "jtest";
		QuestionVO questionVO = new QuestionVO("제목입니다","문의사항입니다2",64,id);
		questionMapper.registerQuestion(questionVO);
	}
		
	// 답변 수정
	@Test
	public void updateQuestion3() {
		int productNo = 1;
		QuestionVO questionVO= questionMapper.questionDetail(productNo);
		System.out.println(questionVO);
	}
	
	// 답변 삭제 
	@Test
	public void deleteReview() {
		int productNo = 1;
		QuestionVO questionVO= questionMapper.questionDetail(productNo);
		System.out.println(questionVO);
	}
	
	// 답변 여부
	@Test
	public void findAnswerByQuestionNo() {
		int productNo = 1;
		AnswerVO answerVO = questionMapper.findAnswerByQuestionNo(productNo);
		System.out.println(answerVO);
	}
	
	// 답변이 달렸으면 답변여부 업데이트
	// UPDATE juiceta_question SET CHECK_ANSWER = 1 WHERE question_no = 109; 
	@Test
	public void updateQuestion() {
		int questionNo = 109;
		questionMapper.updateQuestion(questionNo);
	}
	
	// 장바구니 상세 목록 출력 리스트형식으로 
	// findCartAllListById(in id:String): List
//	@Test
//	public void findCartAllListById() {
//		String id = "jtest3";
//		List<ProductVO> list = cartAndWishlistMapper.findCartAllListById(id);
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
	// SELECT * FROM juiceta_car 총 개수 구하는 메서드
	@Test
	public void countCartById() {
		String id="jtest3";
		int count = cartAndWishlistMapper.countCartById(id);
		System.out.println(count);
	}
	// 장바구니 삭제
	@Test
	public void deleteCartById() {
		int productNo = 64;
		cartAndWishlistMapper.deleteCartById(productNo);
	}
	
	@Test
	public void findAnswerByQuestionNo2() {
		int productNo = 1;
		AnswerVO answerVO = questionMapper.findAnswerByQuestionNo(productNo);
		System.out.println(answerVO);
	}
	
	// 장바구니 총 가격
	@Test
	public void totalCountPrice() {
		String id="jtest3";
		// 	int totalCountPrice(String id);
		int price = cartAndWishlistMapper.totalCountPrice(id);
		System.out.println(price);
	}
	
	@Test
	public void findQuestionCountByProductNo() {
		int productNo=332;
//		int count = questionMapper.findQuestionCountByProductNo(productNo);
//		System.out.println(count);
	}

	@Test
	public void findQuestionByRowNumber() {
		int productNo = 332;
//		int TotalQuestionCount= questionMapper.findQuestionCountByProductNo(productNo);
		String pageNo="";
		Pagination pagination = null;
		
//		if(pageNo == "") 
//			pagination = new Pagination(TotalQuestionCount);
//		else 
//			pagination = new Pagination(Integer.parseInt(pageNo), TotalQuestionCount);
//		Map<String,Object> map = new HashMap<>();
//	@Test
//	public void findQuestionCountByProductNo() {
//		int productNo=332;
//		int count = questionMapper.findQuestionCountByProductNo(productNo);
//		System.out.println(count);
//	}

//	@Test
//	public void findQuestionByRowNumber() {
//		int productNo = 332;
//		int TotalQuestionCount= questionMapper.findQuestionCountByProductNo(productNo);
//		String pageNo="";
//		Pagination pagination = null;
//		
//		if(pageNo == "") 
//			pagination = new Pagination(TotalQuestionCount);
//		else 
//			pagination = new Pagination(Integer.parseInt(pageNo), TotalQuestionCount);
//		Map<String,Object> map = new HashMap<>();
//	@Test
//	public void findQuestionCountByProductNo() {
//		int productNo=332;
//		int count = questionMapper.findQuestionCountByProductNo(productNo);
//		System.out.println(count);
//	}

//	@Test
//	public void findQuestionByRowNumber() {
//		int productNo = 332;
//		int TotalQuestionCount= questionMapper.findQuestionCountByProductNo(productNo);
//		String pageNo="";
//		Pagination pagination = null;
//		
//		if(pageNo == "") 
//			pagination = new Pagination(TotalQuestionCount);
//		else 
//			pagination = new Pagination(Integer.parseInt(pageNo), TotalQuestionCount);
//		Map<String,Object> map = new HashMap<>();
//	@Test
//	public void findQuestionCountByProductNo() {
//		int productNo=332;
//		int count = questionMapper.findQuestionCountByProductNo(productNo);
//		System.out.println(count);
//	}

//	@Test
//	public void findQuestionByRowNumber() {
//		int productNo = 332;
//		int TotalQuestionCount= questionMapper.findQuestionCountByProductNo(productNo);
//		String pageNo="";
//		Pagination pagination = null;
//		
//		if(pageNo == "") 
//			pagination = new Pagination(TotalQuestionCount);
//		else 
//			pagination = new Pagination(Integer.parseInt(pageNo), TotalQuestionCount);
//		Map<String,Object> map = new HashMap<>();
//	@Test
//	public void findQuestionCountByProductNo() {
//		int productNo=332;
//		int count = questionMapper.findQuestionCountByProductNo(productNo);
//		System.out.println(count);
//	}

//	@Test
//	public void findQuestionByRowNumber() {
//		int productNo = 332;
//		int TotalQuestionCount= questionMapper.findQuestionCountByProductNo(productNo);
//		String pageNo="";
//		Pagination pagination = null;
//		
//		if(pageNo == "") 
//			pagination = new Pagination(TotalQuestionCount);
//		else 
//			pagination = new Pagination(Integer.parseInt(pageNo), TotalQuestionCount);
//		Map<String,Object> map = new HashMap<>();
	
		
/*		@Test
	public void findQuestionCountByProductNo() {
		int productNo=332;
		int count = questionMapper.findQuestionCountByProductNo(productNo);
		System.out.println(count);
	}
*/
//	@Test
//	public void findQuestionByRowNumber() {
//		int productNo = 332;
//		int TotalQuestionCount= questionMapper.findQuestionCountByProductNo(productNo);
//		String pageNo="";
//		Pagination pagination = null;
//		
//		if(pageNo == "") 
//			pagination = new Pagination(TotalQuestionCount);
//		else 
//			pagination = new Pagination(Integer.parseInt(pageNo), TotalQuestionCount);
//		Map<String,Object> map = new HashMap<>();
	
//		map.put("PAGINATION",pagination);
////		map.put("PRODUCT_NO", productNo);
////		
////		List<QuestionVO> list = questionMapper.findQuestionByRowNumber(map);
//		
////		for(QuestionVO vo : list) {
////			System.out.println(vo);
////		}
	}
}