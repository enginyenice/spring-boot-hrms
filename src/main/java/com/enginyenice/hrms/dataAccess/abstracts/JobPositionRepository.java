package com.enginyenice.hrms.dataAccess.abstracts;


import com.enginyenice.hrms.entities.dtos.jobPositions.GetAllJobPositionDto;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enginyenice.hrms.entities.concretes.JobPosition;

import java.util.List;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {
    Integer countByName(String name);
    @Query("SELECT new com.enginyenice.hrms.entities.dtos.jobPositions.GetAllJobPositionDto " +
            "(j.id, j.name) from JobPosition j")
    List<GetAllJobPositionDto> getAll();
}
