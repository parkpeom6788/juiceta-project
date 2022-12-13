package org.kosta.juicetaproject.model.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable{
	private static final long serialVersionUID = 2369600641845334659L;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private int enabled;
	private AuthoritiesVO authoritiesVO;

}
