package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListVO {
	private MemberVO memberVO;
	private ProductVO productVO;
}
