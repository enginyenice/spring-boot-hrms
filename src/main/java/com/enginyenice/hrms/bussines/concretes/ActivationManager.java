package com.enginyenice.hrms.bussines.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.enginyenice.hrms.bussines.abstracts.ActivationService;
import com.enginyenice.hrms.bussines.services.email.EmailService;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.ActivationRepository;
import com.enginyenice.hrms.entities.concretes.Activation;
import com.enginyenice.hrms.entities.concretes.User;
import com.enginyenice.hrms.entities.dtos.emailActivations.EmailActivationDto;

@Service
public class ActivationManager  implements ActivationService {
	
	private final EmailService emailService;
	private final ActivationRepository activationRepository;
	
	@Autowired
	public ActivationManager(
			ActivationRepository activationRepository,		
			@Qualifier("smtpEmailService") EmailService emailService
		) {
		super();
		this.emailService = emailService;
		this.activationRepository = activationRepository;
	}

	@Override
	public Result create(User user) {
		Activation activation = Activation.builder().code(UUID.randomUUID().toString()).user(user).build();
		this.activationRepository.save(activation);
		this.emailService.sendEmail(user.getEmail(), "Activation Mail", "Activation Code => " +  activation.getCode() + "\n User Id" + activation.getId());
		
		return new SuccessResult();
	}

	@Override
	public Result delete(EmailActivationDto emailVerifyDto) {
		this.activationRepository.deleteById(emailVerifyDto.getUserId());
		return new SuccessResult();
	}
	

}
