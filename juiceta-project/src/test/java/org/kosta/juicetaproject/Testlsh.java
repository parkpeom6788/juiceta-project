package org.kosta.juicetaproject;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.BoardMapper;
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
	/*
	 * @Test public void boardlist() { List<BoardVO> list =
	 * boardMapper.findBoardAllList(); for(BoardVO vo : list)
	 * System.out.println(vo); }
	 * 
	 * @Test public void boardUpdate() { BoardVO vo = new BoardVO(1, "수정2", "수정2",
	 * null, 0, 0); boardMapper.boardUpdate(vo); List<BoardVO> list =
	 * boardMapper.findBoardAllList(); for(BoardVO bvo : list)
	 * System.out.println(bvo); }
	 * 
	 * @Test public void boardWrite() { String boardTitle = "test"; String
	 * boardContent = "text"; BoardVO vo= new
	 * BoardVO(0,boardTitle,boardContent,null,0, 0); boardMapper.registerBoard(vo);
	 * List<BoardVO> list = (List<BoardVO>) boardMapper.findBoardAllList(null);
	 * for(BoardVO bvo : list) System.out.println(bvo); }
	 * 
	 * @Test void deleteBoard() { int No = 1; boardMapper.deleteBoard(No);
	 * List<BoardVO> list = boardMapper.findBoardAllList(); for(BoardVO bvo : list)
	 * System.out.println(bvo); }
	 */
	
	@Test void countListBoard() {
		int countListBoard = boardMapper.getTotalBoardCount();
		System.out.println(countListBoard);
	}
}
