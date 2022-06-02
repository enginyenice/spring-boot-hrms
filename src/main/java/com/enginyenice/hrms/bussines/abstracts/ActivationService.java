package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.concretes.User;
import com.enginyenice.hrms.entities.dtos.EmailActivationDto;

public interface ActivationService {
	Result create(User user);
	Result delete(EmailActivationDto emailVerifyDto);
}
