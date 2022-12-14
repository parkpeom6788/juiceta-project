package org.kosta.juicetaproject;

import org.junit.jupiter.api.Test;
import org.kosta.juicetaproject.model.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class Testpjs {
	private final CustomerMapper customerMapper;
	@Autowired
	public Testpjs(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}

	@Test
	void contextLoads() {
		System.out.println(customerMapper);
	}

}
