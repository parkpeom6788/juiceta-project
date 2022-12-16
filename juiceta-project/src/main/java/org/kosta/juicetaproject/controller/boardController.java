package org.kosta.juicetaproject.controller;

import org.kosta.juicetaproject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("guest/board-detail")
	public String boardDetail(Model model){
		return null;
	}
}
