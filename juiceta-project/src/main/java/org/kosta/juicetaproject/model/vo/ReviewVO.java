package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {
	private int reviewNo;
	private String reviewContent;
	private int star;
	private String reviewTime;
	private MemberVO memberVO;
	private OrderDetailVO orderDetailVO;
}
