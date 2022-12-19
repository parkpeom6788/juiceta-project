package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailVO {
	private OrderVO orderVO;
	private ProductVO productVO;
	private int orderCount;
}
