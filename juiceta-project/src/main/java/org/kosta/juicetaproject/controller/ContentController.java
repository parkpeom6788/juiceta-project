package org.kosta.juicetaproject.controller;

import java.io.IOException;

import org.kosta.juicetaproject.model.vo.Content;
import org.kosta.juicetaproject.model.vo.ContentForm;
import org.kosta.juicetaproject.model.vo.FileStore;
import org.kosta.juicetaproject.model.vo.UploadFile;
import org.kosta.juicetaproject.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

/*
 	ContentForm으로 입력받아 Content로 변환해주는 부분
 	이 때, form으로 받은 image는 MultipartFile 타입이지만 Content에 들어갈 image는 UploadFile 타입이므로
 	FileStore 클래스의 storeFile 메서드를 사용해 타입변환 + 로컬 디렉토리에 파일 저장
 */

@Controller
@RequiredArgsConstructor
public class ContentController {
	private final FileStore fileStore;
	private final ContentService contentService;
	
	@PostMapping("writeContent")
	public String writeContent(ContentForm form) throws IOException{
		Content content = Content.builder().productNo(form.getProductNo()).productName(form.getProductName()).price(form.getPrice())
									.productCount(form.getProductCount()).productDetail(form.getProductDetail()).category(form.getCategory()).build();
		
		// 이미지 처리하는 부분
		UploadFile image = fileStore.storeFile(form.getImage());	
		content.setImage(image);
		
		contentService.writeContent(content);
		
		return "redirect:/productAdmin";
	}
}











