package org.kosta.juicetaproject.controller;


import org.kosta.juicetaproject.model.vo.BoardVO;
import org.kosta.juicetaproject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class boardController {
	private final BoardService boardService;
	
	@RequestMapping("guest/board")
	public String board(Model model){
		model.addAttribute("boardAllList",boardService.findProductAllList());
		return "board/board-list";
	}
	@RequestMapping("guest/boardResult")
	public String boardResult() {
		return "board/board-detail";
	}
	@RequestMapping("guest/boardDetail")
	public String boardDetail(Model model, int No){
		model.addAttribute("boardDetail",boardService.boardDetail(No));
		return "board/board-detail";
	}
	
	@RequestMapping("guest/boardUpdateForm")
	public String boardUpdateForm(Model model,int No) {
		model.addAttribute("boardUpdate",boardService.boardDetail(No));
		return "board/update-board-form";
	}
	@PostMapping("guest/boardUpdate")
	public String updateBoard(BoardVO boardVO){
		
		System.out.println(boardVO);
		boardService.updateBoard(boardVO);
		
		return "redirect:updateBoardResult";
	}
	@RequestMapping("guest/updateBoardResult")
	public String updateBoardResult() {
		return "board/update-board-result";
	}
}
