package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.BoardVO;
import org.kosta.juicetaproject.model.vo.Pagination;

@Mapper
public interface BoardMapper {

	List<BoardVO> findBoardAllList(Pagination pagination);

	BoardVO boardDetail(int No);

	void boardUpdate(BoardVO vo);

	void registerBoard(BoardVO boardVO);

	void deleteBoard(int no);

	int getTotalBoardCount();

	void boardHitsCount(int no);


}
