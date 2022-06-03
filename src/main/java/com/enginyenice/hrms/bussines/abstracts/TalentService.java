package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.talents.GetAllTalentDto;
import com.enginyenice.hrms.entities.dtos.talents.TalentDto;

import java.util.List;

public interface TalentService {
    Result create(TalentDto talentDto);
    DataResult<List<GetAllTalentDto>> getByCandidateId(int candidateId);
}
