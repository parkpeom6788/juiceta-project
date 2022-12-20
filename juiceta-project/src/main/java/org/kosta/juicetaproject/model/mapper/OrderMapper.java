package org.kosta.juicetaproject.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.OrderDetailVO;
import org.kosta.juicetaproject.model.vo.OrderVO;

@Mapper
public interface OrderMapper {

	void placeAnOrder(OrderVO orderVO);

	void placeAnOrderDetail(Map<String, Integer> map);

	OrderDetailVO findOrderById(String id);

	Map<String, String> findOrderByOrderNo(int productNo);

}
