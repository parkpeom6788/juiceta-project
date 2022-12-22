package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
	private int orderNo;
	private String orderTime;
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;
	private MemberVO memberVO;
}	
