package org.kosta.juicetaproject.model.mapper;

import java.util.List;
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

	List<Map<String, Object>> findOrderListById(String id);

	int getTotalOrderById(String id);

	List<Map<String, Object>> findOrderListByIdPagination(Map<String, Object> map);

	OrderVO findOrderInfoByOrderNo(int orderNo);

	List<Map<String, Object>> findOrderTotalPriceInfoByOrderNo(int orderNo);

	int findTotalCountReview(String id, int orderNo, int productNo);

	void reduceProductCountAfterOrder(Map<String, Integer> map);

	void deleteProductFromCart(String id);

}
