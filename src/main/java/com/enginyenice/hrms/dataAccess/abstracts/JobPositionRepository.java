package com.enginyenice.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enginyenice.hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {
}
