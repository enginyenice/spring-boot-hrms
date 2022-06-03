package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.languages.GetAllLanguageDto;
import com.enginyenice.hrms.entities.dtos.languages.LanguageDto;

import java.util.List;

public interface LanguageService {
    Result create(LanguageDto languageDto);
    DataResult<List<GetAllLanguageDto>> getByCandidateId(int candidateId);
}
