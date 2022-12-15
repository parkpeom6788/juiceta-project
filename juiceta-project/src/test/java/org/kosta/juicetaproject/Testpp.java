package org.kosta.juicetaproject;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.CustomerMapper;
import org.kosta.juicetaproject.model.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Testpp {
	private CustomerMapper customermapper;
	
	@Autowired
	public Testpp(CustomerMapper customermapper) {
		super();
		this.customermapper = customermapper;
	}
	
	@Test
	void contextLoads() {
		System.out.println("1");
	}
	
	// findCustomerInfoById(in id:String): CustomerVO
	@Test
	void findCustomerInfoById() {
		CustomerVO customerVO= customermapper.findCustomerInfoById("javakong");
		System.out.println(customerVO);
	}
}
