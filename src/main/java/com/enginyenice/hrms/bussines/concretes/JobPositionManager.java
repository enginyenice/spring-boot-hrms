package com.enginyenice.hrms.bussines.concretes;
import java.util.List;

import com.enginyenice.hrms.bussines.rules.JobPositionRules;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.core.utilities.rules.BusinessRules;
import com.enginyenice.hrms.entities.dtos.JobPositionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginyenice.hrms.bussines.abstracts.JobPositionService;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.dataAccess.abstracts.JobPositionRepository;
import com.enginyenice.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private final JobPositionRepository jobPositionRepository;
	private final JobPositionRules jobPositionRules;
	private ModelMapper modelMapper;
	@Autowired
	public JobPositionManager(JobPositionRepository jobPositionRepository,
							  JobPositionRules jobPositionRules,
							  ModelMapper modelMapper) {
		this.jobPositionRepository = jobPositionRepository;
		this.jobPositionRules = jobPositionRules;
		this.modelMapper = modelMapper;
	}


	@Override
	public Result create(JobPositionDto jobPositionDto) {
		var businessRuleResult = BusinessRules.Run(this.jobPositionRules.isExistPositionName(jobPositionDto.getName()));

		if(!businessRuleResult.getSuccess())
		{
			return businessRuleResult;
		}

		JobPosition jobPosition = this.modelMapper.map(jobPositionDto, JobPosition.class);
		System.out.println(jobPosition);
		this.jobPositionRepository.save(jobPosition);
		return new SuccessResult("Add Job Position");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionRepository.findAll());
	}

}
