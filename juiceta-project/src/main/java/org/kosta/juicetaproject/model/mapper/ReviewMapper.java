package org.kosta.juicetaproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.ReviewVO;

@Mapper
public interface ReviewMapper {

	void registerReview(ReviewVO reviewVO);


}
