package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.OrderMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
import org.kosta.juicetaproject.model.vo.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderMapper orderMapper;

	@Override
	@Transactional
	public int placeAnOrder(MemberVO memberVO, OrderVO orderVO, int productNo, int productCount) {
		// 주문하기
		orderVO.setMemberVO(memberVO);
		orderMapper.placeAnOrder(orderVO);
		
		// 주문상세내역
		Map<String, Integer> map = new HashMap<>();
		map.put("PRODUCT_NO", productNo);
		map.put("PRODUCT_COUNT", productCount);
		map.put("ORDER_NO", orderVO.getOrderNo());
		orderMapper.placeAnOrderDetail(map);

		return orderVO.getOrderNo();
	}

	@Override
	public OrderVO findOrderByOrderNo(int orderNo) {
		Map<String, String> map = orderMapper.findOrderByOrderNo(orderNo);
		return 	OrderVO.builder().orderNo(orderNo).receiverName(map.get("RECEIVER_NAME")).receiverPhone(map.get("RECEIVER_PHONE")).receiverAddress(map.get("RECEIVER_ADDRESS")).build();
	}

	@Override
	public List<Map<String, Object>> findOrderListById(String id) {
		return orderMapper.findOrderListById(id);
	}

	@Override
	public Map<String, Object> findOrderListByIdPagination(String pageNo, String id) {
		int totalOrder = orderMapper.getTotalOrderById(id);
		Pagination pagination = null;
		
		if(pageNo==null)
			pagination = new Pagination(totalOrder);
		else
			pagination = new Pagination(Integer.parseInt(pageNo), totalOrder);
		
		Map<String, Object> map = new HashMap<>();
		map.put("ID", id);
		map.put("PAGINATION", pagination);

		Map<String, Object> paging = new HashMap<>();
		paging.put("LIST", orderMapper.findOrderListByIdPagination(map));
		paging.put("PAGINATION", pagination);

		return paging;
	}

}





















