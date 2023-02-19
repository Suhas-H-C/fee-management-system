package com.perk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Student_Fee_Management_SystemTests {
	
	@Autowired
	private StudentRepository studentrepository;
	
	@Test
	void testfindByNameExist() {
		String name="David";
		Students res = studentrepository.findByFirstname(name);
		assertThat(res.getFirstname()).isEqualTo(name);
	}

}
