package com.enginyenice.hrms.dataAccess.abstracts;

import com.enginyenice.hrms.entities.dtos.GetAllEmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enginyenice.hrms.entities.concretes.Employer;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    @Query("SELECT new com.enginyenice.hrms.entities.dtos.GetAllEmployerDto "
           +"(u.email, e.companyName,e.webSite,e.phoneNumber ) "
           +" from Employer e inner join e.user u")
    List<GetAllEmployerDto> getAll();
}
