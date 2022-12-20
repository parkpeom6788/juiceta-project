package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 여기에 파일을 담아두는 것이 아닌 UploadFile에서 묶은 파일명을 담는 것임 

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Content {
	private int productNo;
	private String productName;
	private int price;
	private int productCount;
	private String productDetail;
	private UploadFile image;
	private String category;
}
