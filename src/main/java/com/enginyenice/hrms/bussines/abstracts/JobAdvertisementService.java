package com.enginyenice.hrms.bussines.abstracts;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.dtos.jobAdvertisements.GetAllJobAdvertisementDto;
import com.enginyenice.hrms.entities.dtos.jobAdvertisements.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {
    Result create(JobAdvertisementDto jobAdvertisementDto);
    DataResult<List<GetAllJobAdvertisementDto>> getAll();
    DataResult<List<GetAllJobAdvertisementDto>> getAllByEmployerId(int employerId);
}
