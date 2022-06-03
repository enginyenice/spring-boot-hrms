package com.enginyenice.hrms.bussines.concretes;
import com.enginyenice.hrms.core.utilities.results.*;
import com.enginyenice.hrms.entities.dtos.employers.GetAllEmployerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginyenice.hrms.bussines.abstracts.EmployerService;
import com.enginyenice.hrms.bussines.abstracts.UserService;
import com.enginyenice.hrms.bussines.rules.EmployerRules;
import com.enginyenice.hrms.bussines.rules.UserRules;
import com.enginyenice.hrms.core.utilities.rules.BusinessRules;
import com.enginyenice.hrms.dataAccess.abstracts.EmployerRepository;
import com.enginyenice.hrms.entities.concretes.Employer;
import com.enginyenice.hrms.entities.concretes.User;
import com.enginyenice.hrms.entities.dtos.employers.EmployerDto;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

	private final EmployerRepository employerRepository;
	private final UserService userService;
	private ModelMapper modelMapper;
	private final UserRules userRules;
	private final EmployerRules employerRules;

	public EmployerManager(	EmployerRepository employerRepository, 
							UserService userService, 
							ModelMapper modelMapper,
							UserRules userRules,
							EmployerRules employerRules) {
		super();
		this.employerRepository = employerRepository;
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.userRules = userRules;
		this.employerRules = employerRules;
	}

	@Override
	public Result create(EmployerDto employerDto) {		
		var result = BusinessRules.run(
				this.employerRules.DoesEmailAndWebsiteMatch(employerDto.getEmail(), employerDto.getWebSite()),
				this.userRules.IsExistEmail(employerDto.getEmail())
				);
		
		if(!result.getSuccess())
		{
			return result;
		}
		
		User user = modelMapper.map(employerDto, User.class);
		user.setEmployer(null);
		user.setId(0);
		user.setHrmsVerification(false);
		user.setEmailVerification(false);
		
		var userData = this.userService.create(user);
		if(!userData.getSuccess())
		{
			return new ErrorResult("User not created");
		}
		Employer employer = modelMapper.map(employerDto, Employer.class);
		employer.setUser(userData.getData());
		employerRepository.save(employer);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<GetAllEmployerDto>> getAll() {
		return new SuccessDataResult<>(this.employerRepository.getAll());
	}

}
