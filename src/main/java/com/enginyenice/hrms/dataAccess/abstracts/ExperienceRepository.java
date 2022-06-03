package com.enginyenice.hrms.dataAccess.abstracts;

import com.enginyenice.hrms.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
    List<Experience> getByCandidate_IdOrderByEndYearDesc(int candidateId);
}
