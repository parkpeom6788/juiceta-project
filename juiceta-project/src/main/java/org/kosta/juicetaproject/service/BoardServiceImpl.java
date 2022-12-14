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
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
	}

	@Override
	public void deleteBoard(int boardNo) {
	}

	@Override
	public BoardVO boardDetail(int baordNo) {
		return null;
	}

}
