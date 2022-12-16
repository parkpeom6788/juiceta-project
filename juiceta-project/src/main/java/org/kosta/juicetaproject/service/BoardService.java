package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.vo.BoardVO;

public interface BoardService {

	List<BoardVO> findProductAllList();
	void registerBoard(BoardVO boardVO);
	void updateBoard(BoardVO boardVO);
	void deleteBoard(int boardNo);
	BoardVO boardDetail(int No);
	
	

}
