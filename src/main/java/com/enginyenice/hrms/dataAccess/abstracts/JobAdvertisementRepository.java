package com.enginyenice.hrms.dataAccess.abstracts;

import com.enginyenice.hrms.entities.concretes.JobAdvertisement;
import com.enginyenice.hrms.entities.dtos.jobAdvertisements.GetAllJobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Integer> {
    @Query("SELECT new com.enginyenice.hrms.entities.dtos.jobAdvertisements.GetAllJobAdvertisementDto" +
            "(employer.companyName," +
            "jobPosition.name," +
            "city.name," +
            "jobAdvertisement.minimumSalary," +
            "jobAdvertisement.maximumSalary," +
            "jobAdvertisement.description," +
            "jobAdvertisement.piece," +
            "jobAdvertisement.deadline) " +
            "from JobAdvertisement jobAdvertisement " +
            "inner join jobAdvertisement.city city " +
            "inner join jobAdvertisement.employer employer " +
            "inner join jobAdvertisement.jobPosition jobPosition " +
            "where jobAdvertisement.deadline > current_date")
    List<GetAllJobAdvertisementDto> getAll();

    @Query("SELECT new com.enginyenice.hrms.entities.dtos.jobAdvertisements.GetAllJobAdvertisementDto" +
            "(employer.companyName," +
            "jobPosition.name," +
            "city.name," +
            "jobAdvertisement.minimumSalary," +
            "jobAdvertisement.maximumSalary," +
            "jobAdvertisement.description," +
            "jobAdvertisement.piece," +
            "jobAdvertisement.deadline) " +
            "from JobAdvertisement jobAdvertisement " +
            "inner join jobAdvertisement.city city " +
            "inner join jobAdvertisement.employer employer " +
            "inner join jobAdvertisement.jobPosition jobPosition " +
            "where jobAdvertisement.deadline > current_date and " +
            "employer.id =:employerId"
            )
    List<GetAllJobAdvertisementDto> getAllByEmployerId(int employerId);
}
