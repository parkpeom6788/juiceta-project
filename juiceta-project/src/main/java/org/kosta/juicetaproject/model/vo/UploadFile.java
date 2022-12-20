package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 	사용자가 이미지나 파일을 업로드하면 이 파일이 로컬 디렉토리에 저장됨
 	만약 저장할 때 파일 이름을 사용자가 업로드한 그대로 저장한다면 이름의 중복이 생겨 덮어쓰기가 될 수 있음
 	이를 해결하기 위해 UploadFile이라는 객체를 만들고 업로드한 파일명과 서버에서 저장한 파일명을 묶어서 저장해 놓음
 */
@Data
@AllArgsConstructor
public class UploadFile {
	private String uploadFilename;	// 작성자가 업로드한 파일명
	private String storeFilename;	// 서버 내부에서 관리하는 파일명
}
