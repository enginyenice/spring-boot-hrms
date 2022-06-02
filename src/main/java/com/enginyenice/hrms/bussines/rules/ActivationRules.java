package com.enginyenice.hrms.bussines.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enginyenice.hrms.core.utilities.results.ErrorResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.ActivationRepository;
import com.enginyenice.hrms.entities.dtos.EmailActivationDto;

@Component
public class ActivationRules {
	private final ActivationRepository activationRepository;
	
	@Autowired
	public ActivationRules(ActivationRepository activationRepository) {
		super();
		this.activationRepository = activationRepository;
	}

	public Result isExistVerify(EmailActivationDto emailActivationDto) {
		if(this.activationRepository.findByIdAndCode(emailActivationDto.getUserId(), emailActivationDto.getCode()) == null)
		{
			return new ErrorResult("Activation Information Not True");
		}
		
		return new SuccessResult();
	}

}
