package com.enginyenice.hrms.bussines.rules;

import org.springframework.stereotype.Component;

import com.enginyenice.hrms.core.utilities.results.ErrorResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.CandidateRepository;

@Component
public class CandidateRules {
	private final CandidateRepository candidateRepository;
	public CandidateRules(CandidateRepository candidateRepository)
	{
		this.candidateRepository = candidateRepository;
	}
	
	public Result IsExistNationalityNumber(String nationalityNumber)
	{
		if(this.candidateRepository.findByNationalityNumber(nationalityNumber) != null)
		{
			return new ErrorResult("Nationality Number is exist");
		}
		return new SuccessResult();
	}
}
