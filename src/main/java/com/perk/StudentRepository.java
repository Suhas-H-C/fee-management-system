package com.perk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Integer> {
	
	public Students getById(int id);
	public Students findByFirstname(String firstname);
	
}
