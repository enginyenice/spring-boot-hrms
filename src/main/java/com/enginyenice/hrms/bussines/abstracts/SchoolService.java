package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.schools.GetAllSchoolDto;
import com.enginyenice.hrms.entities.dtos.schools.SchoolDto;

import java.util.List;

public interface SchoolService {
    Result create(SchoolDto schoolDto);
    DataResult<List<GetAllSchoolDto>> getByCandidateId(int candidateId);
}
