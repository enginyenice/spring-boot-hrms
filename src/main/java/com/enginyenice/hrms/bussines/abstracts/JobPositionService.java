package com.enginyenice.hrms.bussines.abstracts;

import java.util.List;

import com.enginyenice.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
