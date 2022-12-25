package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.BoardMapper;
import org.kosta.juicetaproject.model.vo.BoardVO;
import org.kosta.juicetaproject.model.vo.Pagination;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper boardMapper;
	
	@Override
	public Map<String, Object> findboardAllList(String pageNo) {
		int totalBoardCount = boardMapper.getTotalBoardCount();
		Pagination pagination = null;
		if(pageNo==null)
			pagination = new Pagination(totalBoardCount);
		else
			pagination = new Pagination(Integer.parseInt(pageNo), totalBoardCount);
		
		pagination.setPostCountPerPage(10);
		
		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", boardMapper.findBoardAllList(pagination));
		
		if(totalBoardCount==0)
			pagination = null;
		
		paging.put("PAGINATION",pagination);
		return paging;
	}

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

	@Override
	public void boardHitsCount(int no) {
		boardMapper.boardHitsCount(no);
	}

}
