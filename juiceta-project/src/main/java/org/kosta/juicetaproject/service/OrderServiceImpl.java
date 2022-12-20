package org.kosta.juicetaproject.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.juicetaproject.model.mapper.OrderMapper;
import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderVO;
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

}





















