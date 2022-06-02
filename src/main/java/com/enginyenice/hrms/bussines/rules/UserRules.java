package com.enginyenice.hrms.bussines.rules;

import org.springframework.stereotype.Component;

import com.enginyenice.hrms.core.utilities.results.ErrorResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.UserRepository;

@Component
public class UserRules {
	private final UserRepository userRepository;
	public UserRules(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	public Result IsExistEmail(String email)
	{
		if(this.userRepository.findByEmail(email) != null)
		{
			return new ErrorResult("Email is exist");
		}
		return new SuccessResult();
		
	}
}
