package com.enginyenice.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enginyenice.hrms.entities.concretes.Candidate;
import com.enginyenice.hrms.entities.dtos.candaidates.GetAllCandidateDto;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	Integer countByNationalityNumber(String nationalityNumber);
	@Query("SELECT new com.enginyenice.hrms.entities.dtos.candaidates.GetAllCandidateDto "
			+"(u.email, c.firstName, c.lastName, c.nationalityNumber, c.yearOfBirth) "
			+"from Candidate c inner join c.user u ")
	List<GetAllCandidateDto> getAll();
}
