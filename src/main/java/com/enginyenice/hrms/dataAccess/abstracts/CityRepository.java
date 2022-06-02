package com.enginyenice.hrms.dataAccess.abstracts;

import com.enginyenice.hrms.entities.concretes.City;
import com.enginyenice.hrms.entities.dtos.cities.GetAllCityDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    Integer countCityByName(String name);
    @Query("Select new com.enginyenice.hrms.entities.dtos.cities.GetAllCityDto " +
            "(c.id,c.name) from City c")
    List<GetAllCityDto> getAll();
}
