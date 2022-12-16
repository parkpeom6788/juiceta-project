package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	private int productNo;
	private String productName;
	private int price;
	private int productCount;
	private String productDetail;
	private String image;
	private String category;
}
