package com.enginyenice.hrms.bussines.abstracts;


import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.cities.CityDto;
import com.enginyenice.hrms.entities.dtos.cities.GetAllCityDto;

import java.util.List;

public interface CityService {
    Result create(CityDto cityDto);
    DataResult<List<GetAllCityDto>> getAll();
}
