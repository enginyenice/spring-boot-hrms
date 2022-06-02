package com.enginyenice.hrms.bussines.abstracts;

import java.util.List;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateDto;
import com.enginyenice.hrms.entities.dtos.candaidates.GetAllCandidateDto;

public interface CandidateService {
    Result create(CandidateDto candidateDto);
    DataResult<List<GetAllCandidateDto>> getAll();
}
