package com.enginyenice.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginyenice.hrms.entities.concretes.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByEmail(String email);
	Integer countByEmail(String email);
	User findById(int id);
}
