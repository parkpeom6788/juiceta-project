package org.kosta.juicetaproject.service;

import java.util.List;

import org.kosta.juicetaproject.model.mapper.BoardMapper;
import org.kosta.juicetaproject.model.vo.BoardVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper boardMapper;
	@Override
	public List<BoardVO> findProductAllList() {
		
		return boardMapper.findBoardAllList();
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

}