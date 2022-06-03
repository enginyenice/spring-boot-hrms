package com.enginyenice.hrms.dataAccess.abstracts;

import com.enginyenice.hrms.entities.concretes.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalentRepository extends JpaRepository<Talent,Integer> {
    List<Talent> getByCandidate_Id(int candidateId);
}
