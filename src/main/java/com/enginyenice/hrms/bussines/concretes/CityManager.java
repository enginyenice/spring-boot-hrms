package com.enginyenice.hrms.bussines.concretes;

import com.enginyenice.hrms.bussines.abstracts.CityService;
import com.enginyenice.hrms.bussines.rules.CityRules;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.core.utilities.rules.BusinessRules;
import com.enginyenice.hrms.dataAccess.abstracts.CityRepository;
import com.enginyenice.hrms.entities.concretes.City;
import com.enginyenice.hrms.entities.dtos.cities.CityDto;
import com.enginyenice.hrms.entities.dtos.cities.GetAllCityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityRules cityRules;
    private final CityRepository cityRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CityManager(CityRules cityRules, CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRules = cityRules;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result create(CityDto cityDto) {
        var businessRuleResult = BusinessRules.Run(this.cityRules.isExistName(cityDto.getName()));
        if(!businessRuleResult.getSuccess())
        {
            return  businessRuleResult;
        }

        City city = this.modelMapper.map(cityDto,City.class);
        this.cityRepository.save(city);
        return new SuccessResult("City created");
    }

    @Override
    public DataResult<List<GetAllCityDto>> getAll() {
        return new SuccessDataResult<>(this.cityRepository.getAll());
    }
}
