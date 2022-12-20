package org.kosta.juicetaproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.BoardPagination;
import org.kosta.juicetaproject.model.vo.BoardVO;

@Mapper
public interface BoardMapper {

	Map<String, Object> findBoardAllList(BoardPagination boardPagination);

	BoardVO boardDetail(int No);

	void boardUpdate(BoardVO vo);

	void registerBoard(BoardVO boardVO);

	void deleteBoard(int no);

	int getTotalBoardCount();


}
