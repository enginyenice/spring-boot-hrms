package com.enginyenice.hrms.dataAccess.abstracts;

import com.enginyenice.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    List<Language> getByCandidate_Id(int candidateId);
}
