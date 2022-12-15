package org.kosta.juicetaproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.CustomerVO;

@Mapper
public interface CustomerMapper {
	CustomerVO findCustomerInfoById(String id);
}
