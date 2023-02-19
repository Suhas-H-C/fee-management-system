package com.perk;

import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

	public Students getStudentObject(StudentDTO student) {
		Students stdd = new Students();
		stdd.setId(student.getId());
		stdd.setAddress(student.getAddress());
		stdd.setAge(student.getAge());
		stdd.setFeedue(student.getFeedue());
		stdd.setFeepaid(student.getFeepaid());
		stdd.setFirstname(student.getFirstname());
		stdd.setLastname(student.getLastname());
		
		return stdd;
	}
}
