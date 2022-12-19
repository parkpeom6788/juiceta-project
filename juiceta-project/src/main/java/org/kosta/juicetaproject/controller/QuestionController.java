package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.model.vo.AnswerVO;
import org.kosta.juicetaproject.model.vo.QuestionVO;
import org.kosta.juicetaproject.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {
	private final QuestionService questionService; 
		
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
		 @PostMapping("guest/registerQuestion")
		 public String registerQuestion(String questionTitle,String questionContent,int productNo) {
			 String id = "jtest";
			 questionService.registerQuestion(questionTitle,questionContent,productNo,id);
			 return "redirect:registerQuestionresultok";
		 }
		 // 글쓰기 결과
		 @RequestMapping("guest/registerQuestionresultok")
		 public String registerQuestionresultok() {
			 return "/";
		 }
		 // 관리자 답변
		 @PostMapping("guest/registerAnswer")
		 public String registerAnswer(Model model , String answerContent, int questionNo) {
			 questionService.registerAnswer(new AnswerVO(questionNo,answerContent));
			 model.addAttribute("answerContent", answerContent);
			 return "qnaboard/board-detail?questionNo="+questionNo;
		 }
}
