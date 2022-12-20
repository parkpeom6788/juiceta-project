package org.kosta.juicetaproject.service;

import org.kosta.juicetaproject.model.vo.MemberVO;
import org.kosta.juicetaproject.model.vo.OrderVO;

public interface OrderService {

	int placeAnOrder(MemberVO memberVO, OrderVO orderVO, int productNo, int productCount);

	OrderVO findOrderByOrderNo(int orderNo);

}
