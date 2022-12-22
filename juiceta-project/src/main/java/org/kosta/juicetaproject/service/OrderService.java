package org.kosta.juicetaproject.service;

import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderVO;

public interface OrderService {

	int placeAnOrder(MemberVO memberVO, OrderVO orderVO, int productNo, int productCount);

	OrderVO findOrderByOrderNo(int orderNo);

	List<Map<String, Object>> findOrderListById(String id);

	Map<String, Object> findOrderListByIdPagination(String pageNo, String id);
	
	OrderVO findOrderInfoByOrderNo(int orderNo);
	
	List<Map<String, Object>> findOrderTotalPriceInfoByOrderNo(int orderNo);
	
}
