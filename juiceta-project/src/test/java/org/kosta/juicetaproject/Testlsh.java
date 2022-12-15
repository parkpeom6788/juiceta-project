package org.kosta.juicetaproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.BoardMapper;
import org.kosta.juicetaproject.model.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testlsh {
	private final BoardMapper boardMapper;
	
	@Autowired
	public Testlsh(BoardMapper boardmapper) {
		super();
		this.boardMapper = boardmapper;
	}
	
	@Test
	void contextLoads() {
	}
	@Test
	public void boardlist() {
		List<BoardVO> list = boardMapper.findBoardAllList();
		for(BoardVO vo : list)
			System.out.println(vo);
	}

}
