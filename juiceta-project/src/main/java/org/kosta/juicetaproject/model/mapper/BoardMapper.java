package org.kosta.juicetaproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.BoardVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> findBoardAllList();

	BoardVO boardDetail(int No);

	void boardUpdate(BoardVO vo);

	void registerBoard(BoardVO boardVO);

	void deleteBoard(int no);


}