package org.kosta.juicetaproject.model.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 	전에는 form 입력을 Content 객체로 받았음
 	이제는 ContentForm이라는 DTO를 생성하고 이 객체로 입력을 받은 후 Content 객체로 변환시켜 줘야함
 		- 입력 image의 데이터 타입이 달라졌기 때문
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentForm {
	private int productNo;
	private String productName;
	private int price;
	private int productCount;
	private String productDetail;
	private MultipartFile image;
	private String category;

}
