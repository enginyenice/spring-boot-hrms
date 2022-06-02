package com.enginyenice.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enginyenice.hrms.entities.concretes.Activation;
@Repository
public interface ActivationRepository extends JpaRepository<Activation, Integer> {
	Activation findByIdAndCode(int id,String code);
}
