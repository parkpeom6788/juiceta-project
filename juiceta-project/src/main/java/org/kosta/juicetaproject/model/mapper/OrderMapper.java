package org.kosta.juicetaproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.juicetaproject.model.vo.OrderDetailVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
import org.kosta.juicetaproject.model.vo.Pagination;

@Mapper
public interface OrderMapper {

	void placeAnOrder(OrderVO orderVO);

	void placeAnOrderDetail(Map<String, Integer> map);

	OrderDetailVO findOrderById(String id);

	Map<String, String> findOrderByOrderNo(int productNo);

	List<Map<String, Object>> findOrderListById(String id);

	int getTotalOrderById(String id);

	List<Map<String, Object>> findOrderListByIdPagination(Pagination pagination);

}
