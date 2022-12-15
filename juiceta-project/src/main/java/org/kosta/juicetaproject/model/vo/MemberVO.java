package org.kosta.juicetaproject.model.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class MemberVO implements Serializable{	
	private static final long serialVersionUID = 6440047762418162093L;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String enabled;
	
}
