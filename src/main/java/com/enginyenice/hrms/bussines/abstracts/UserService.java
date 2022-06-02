package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.concretes.User;
import com.enginyenice.hrms.entities.dtos.emailActivations.EmailActivationDto;


public interface UserService {
	DataResult<User> create(User user);
	Result emailActivator(EmailActivationDto emailVerifyDto);
}
