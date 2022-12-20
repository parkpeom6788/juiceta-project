package org.kosta.juicetaproject.controller;

import org.springframework.stereotype.Controller;

/*
 	ContentForm으로 입력받아 Content로 변환해주는 부분
 	이 때, form으로 받은 image는 MultipartFile 타입이지만 Content에 들어갈 image는 UploadFile 타입이므로
 	FileStore 클래스의 storeFile 메서드를 사용해 타입변환 + 로컬 디렉토리에 파일 저장
 */

@Controller
public class ContentController {

}
