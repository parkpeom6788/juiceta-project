package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.kosta.juicetaproject.service.ProductService;
import org.kosta.juicetaproject.service.QuestionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {
	private final QuestionService questionService; 
	private final ProductService productService;
		
	// 상세페이지로 이동
		@RequestMapping("guest/question-detail")
		public String questionDetail(int questionNo , Model model) {
		    QuestionVO questionVO= questionService.questionDetail(questionNo);
		    AnswerVO answerVO = questionService.findAnswerByQuestionNo(questionNo);
		    model.addAttribute("questionVO", questionVO);
		    model.addAttribute("answerVO", answerVO);
			return "qnaboard/board-detail";
		 }
		// 글쓰기 폼으로 
		 @RequestMapping("guest/question-write")
		 public String questionWrite(int productNo, Model model) {
			 System.out.println("asdsad");
			 model.addAttribute("productNo", productNo);
			 return "qnaboard/board-write-form";
		 }
		 // 글쓰기 작업
		 @PostMapping("registerQuestion")
		 public String registerQuestion(@AuthenticationPrincipal MemberVO memberVO, String questionTitle,String questionContent,int productNo) {
			 questionService.registerQuestion(questionTitle,questionContent,productNo,memberVO.getId());
			 return "redirect:registerQuestionresultok?productNo="+productNo;
		 }
		 // 글쓰기 결과
		 @RequestMapping("registerQuestionresultok")
		 public String registerQuestionresultok(int productNo, Model model) {
			 model.addAttribute("productVO", productService.findProductByProductNo(productNo));
			 model.addAttribute("questionAllList", questionService.findQuestionAllListByProductNo(productNo));
			 return "product/product-detail";
		 }
		 // 관리자 답변
		 @PostMapping("guest/registerAnswer")
		 public String registerAnswer(Model model , String answerContent, int questionNo) {
			 questionService.registerAnswer(new AnswerVO(questionNo,answerContent));
			 model.addAttribute("answerContent", answerContent);
			 return "qnaboard/board-detail?questionNo="+questionNo;
		 }
}
