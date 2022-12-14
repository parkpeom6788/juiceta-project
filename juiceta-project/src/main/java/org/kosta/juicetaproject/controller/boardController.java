package org.kosta.juicetaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class boardController {
	@RequestMapping("/board")
	public String board(){
		return "board/board-list";
	}
}
