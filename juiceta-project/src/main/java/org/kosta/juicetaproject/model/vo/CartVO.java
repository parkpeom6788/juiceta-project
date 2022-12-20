package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {
	private MemberVO memberVO;
	private ProductVO productVO;
	private int productCount;
}
