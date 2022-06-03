package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.experiences.ExperienceDto;
import com.enginyenice.hrms.entities.dtos.experiences.GetAllExperienceDto;

import java.util.List;

public interface ExperienceService {
    Result  create(ExperienceDto experienceDto);
    DataResult<List<GetAllExperienceDto>> getByCandidateId(int candidateId);
}
