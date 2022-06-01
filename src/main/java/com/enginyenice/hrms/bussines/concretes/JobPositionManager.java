package com.enginyenice.hrms.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginyenice.hrms.bussines.abstracts.JobPositionService;
import com.enginyenice.hrms.dataAccess.abstracts.JobPositionRepository;
import com.enginyenice.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private final JobPositionRepository jobPositionRepository;
	
	@Autowired
	public JobPositionManager(JobPositionRepository jobPositionRepository) {
		this.jobPositionRepository = jobPositionRepository;
	}
	
	
	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionRepository.findAll();
	}

}
