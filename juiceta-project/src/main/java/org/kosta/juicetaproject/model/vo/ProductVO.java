package org.kosta.juicetaproject.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductVO {
	private int productNo;
	private String productName;
	private int price;
	private int productCount;
	private String productDetail;
	private String image;
	private String category;
}
