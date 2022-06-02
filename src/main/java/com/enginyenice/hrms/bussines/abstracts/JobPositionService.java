package com.enginyenice.hrms.bussines.abstracts;

import java.util.List;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.concretes.JobPosition;
import com.enginyenice.hrms.entities.dtos.jobPositions.GetAllJobPositionDto;
import com.enginyenice.hrms.entities.dtos.jobPositions.JobPositionDto;

public interface JobPositionService {
	Result create(JobPositionDto jobPositionDto);
	DataResult<List<GetAllJobPositionDto>> getAll();
}
