package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.BoardMapper;
import org.kosta.juicetaproject.model.vo.BoardPagination;
import org.kosta.juicetaproject.model.vo.BoardVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper boardMapper;
	@Override
	public Map<String, Object> findboardAllList(String pageNo) {
		int totalBoardCount = boardMapper.getTotalBoardCount();
		BoardPagination boardPagination = null;
		if(pageNo==null)
			boardPagination = new BoardPagination(totalBoardCount);
		else
			boardPagination = new BoardPagination(Integer.parseInt(pageNo), totalBoardCount);
		
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", boardMapper.findBoardAllList(boardPagination));
		paging.put("PAGINATION",boardPagination);
		return paging;
	}
//	public List<BoardVO> findProductAllList() {
//		return boardMapper.findBoardAllList();
//	}

	@Override
	public void registerBoard(BoardVO boardVO) {
		boardMapper.registerBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardMapper.boardUpdate(boardVO);
	}

	@Override
	public void deleteBoard(int boardNo) {
		boardMapper.deleteBoard(boardNo);
	}

	@Override
	public BoardVO boardDetail(int No) {
		return boardMapper.boardDetail(No);
	}

	

}
