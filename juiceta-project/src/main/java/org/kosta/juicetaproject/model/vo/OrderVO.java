package org.kosta.juicetaproject.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderVO {
	private int orderNo;
	private String orderTime;
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;
	private MemberVO memberVO;
}	
