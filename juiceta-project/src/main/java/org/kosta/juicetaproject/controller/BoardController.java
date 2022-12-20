package org.kosta.juicetaproject.controller;


import java.util.Map;

import org.kosta.juicetaproject.model.vo.BoardVO;
import org.kosta.juicetaproject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@RequestMapping("guest/board")
	public String board(Model model, String pageNo){
		Map<String, Object> paging = boardService.findboardAllList(pageNo);
		model.addAttribute("boardAllList", paging.get("LIST"));
		model.addAttribute("pagination", paging.get("PAGINATION"));
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
		boardService.updateBoard(boardVO);
		return "redirect:updateBoardResult";
	}
	@RequestMapping("guest/updateBoardResult")
	public String updateBoardResult() {
		return "board/update-board-result";
	}
	@RequestMapping("guest/boardWriteForm")
	public String baordWrite() {
		return "board/write-board";
	}
	@PostMapping("guest/boardWrite")
	public String boardWrite(Model model,BoardVO boardVO) {
		boardService.registerBoard(boardVO);
		return "redirect:boardWriteResult";
	}
	@RequestMapping("guest/boardWriteResult")
	public String boardWriteResult() {
		return "board/register-board-result.html";
	}
	@PostMapping("guest/boardDelete")
	public String boardDelete(Model model, int boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:deleteBoardResult";
	}
	@RequestMapping("guest/deleteBoardResult")
	public String deleteBoardResult() {
		return "board/delete-board-reuslt";
	}
}
