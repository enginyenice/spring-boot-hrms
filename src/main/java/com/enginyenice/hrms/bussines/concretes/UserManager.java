package com.enginyenice.hrms.bussines.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginyenice.hrms.bussines.abstracts.ActivationService;
import com.enginyenice.hrms.bussines.abstracts.UserService;
import com.enginyenice.hrms.bussines.rules.ActivationRules;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.core.utilities.rules.BusinessRules;
import com.enginyenice.hrms.dataAccess.abstracts.UserRepository;
import com.enginyenice.hrms.entities.concretes.User;
import com.enginyenice.hrms.entities.dtos.emailActivations.EmailActivationDto;

@Service
public class UserManager implements UserService {

	private final UserRepository userRepository;
	private final ActivationService activationService;
	private final ActivationRules activationRules;
	
	@Autowired
	public UserManager(UserRepository userRepository,ModelMapper modelMapper,ActivationService activationService,ActivationRules activationRules) {
		super();
		this.userRepository = userRepository;
		this.activationService = activationService;
		this.activationRules = activationRules;
	}

	@Override
	public DataResult<User> create(User user) {
		userRepository.save(user);
		
		if(user.isEmailVerification() == false)
		{
			this.activationService.create(user);
		}
		
		return new SuccessDataResult<User>(user);
	}

	
	@Override
	public Result emailActivator(EmailActivationDto emailVerifyDto) {
		var result = BusinessRules.run(this.activationRules.isExistVerify(emailVerifyDto));
		if(!result.getSuccess())
		{
			return result;
		}
		
		this.activationService.delete(emailVerifyDto);
		User user = this.userRepository.findById(emailVerifyDto.getUserId());
		user.setEmailVerification(true);
		return new SuccessResult("Activation Successfuly");
	}

}
