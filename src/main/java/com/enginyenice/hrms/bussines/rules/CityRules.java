package com.enginyenice.hrms.bussines.rules;

import com.enginyenice.hrms.core.utilities.results.ErrorResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityRules {

    private final CityRepository cityRepository;
    @Autowired
    public CityRules(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Result isExistName(String name){
        if(this.cityRepository.countCityByName(name) > 0)
        {
            return new ErrorResult("City name is exists");
        }
        return new SuccessResult();
    }
}
