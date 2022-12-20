package org.kosta.juicetaproject.service;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.BoardVO;

public interface BoardService {

	Map<String, Object> findboardAllList(String pagNo);
	void registerBoard(BoardVO boardVO);
	void updateBoard(BoardVO boardVO);
	void deleteBoard(int boardNo);
	BoardVO boardDetail(int No);
	void boardHitsCount(int no);
	
	

}
