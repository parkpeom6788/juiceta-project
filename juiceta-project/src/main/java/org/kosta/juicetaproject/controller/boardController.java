package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class boardController {
	private final BoardService boardService;
	
	@RequestMapping("guest/board")
	public String board(Model model){
		model.addAttribute("boardAllList",boardService.findProductAllList());
		return "board/board-list";
	}
	@RequestMapping("guest/boardDetail")
	public String boardDetail(Model model, int No){
		model.addAttribute("boardDetail",boardService.boardDetail(No));
		return "board/board-detail";
	}
	
	@RequestMapping("guest/boardUpdateForm")
	public String boardUpdateForm(Model model,int No) {
		System.out.println(No);
		model.addAttribute("boardUpdate",boardService.boardDetail(No));
		return "board/update-board-form";
	}
	@PostMapping("guest/boardUpdate")
	public String boardUpdate() {
		return null;
		
	}
}
