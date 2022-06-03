package com.enginyenice.hrms.bussines.concretes;

import com.enginyenice.hrms.bussines.abstracts.JobAdvertisementService;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import com.enginyenice.hrms.entities.concretes.JobAdvertisement;
import com.enginyenice.hrms.entities.dtos.jobAdvertisements.GetAllJobAdvertisementDto;
import com.enginyenice.hrms.entities.dtos.jobAdvertisements.JobAdvertisementDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementRepository jobAdvertisementRepository;
    private ModelMapper modelMapper;

    public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository, ModelMapper modelMapper) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Result create(JobAdvertisementDto jobAdvertisementDto) {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true);
        JobAdvertisement jobAdvertisement = this.modelMapper.map(jobAdvertisementDto,JobAdvertisement.class);
        jobAdvertisement.setId(0);
        this.jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementDto>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertisementRepository.getAll());
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementDto>> getAllByEmployerId(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertisementRepository.getAllByEmployerId(employerId));
    }


}
