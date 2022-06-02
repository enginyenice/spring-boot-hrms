package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.entities.dtos.employers.GetAllEmployerDto;

import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.employers.EmployerDto;

import java.util.List;

public interface EmployerService {
	Result create(EmployerDto employerDto);
	DataResult<List<GetAllEmployerDto>> getAll();
}
