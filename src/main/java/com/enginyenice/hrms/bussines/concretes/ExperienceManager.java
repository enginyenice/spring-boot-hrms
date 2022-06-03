package com.enginyenice.hrms.bussines.concretes;

import com.enginyenice.hrms.bussines.abstracts.ExperienceService;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.ExperienceRepository;
import com.enginyenice.hrms.entities.concretes.Experience;
import com.enginyenice.hrms.entities.dtos.experiences.ExperienceDto;
import com.enginyenice.hrms.entities.dtos.experiences.GetAllExperienceDto;
import com.enginyenice.hrms.entities.dtos.schools.GetAllSchoolDto;
import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private ModelMapper modelMapper;
    public ExperienceManager(ExperienceRepository experienceRepository, ModelMapper modelMapper) {
        this.experienceRepository = experienceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result create(ExperienceDto experienceDto) {


        if(experienceDto.getEndYear().isEmpty())
        {
            experienceDto.setEndYear("Devam ediyor");
        }

        Experience experience = this.modelMapper.map(experienceDto,Experience.class);
        experience.setId(0);
        this.experienceRepository.save(experience);
        return new SuccessResult();


    }

    @Override
    public DataResult<List<GetAllExperienceDto>> getByCandidateId(int candidateId) {
        Sort sort = Sort.by(Sort.Direction.DESC,"endYear");
        List<GetAllExperienceDto> experienceDtos =
                    this.modelMapper.map
                            (this.experienceRepository.getByCandidate_IdOrderByEndYearDesc(candidateId), new TypeToken<List<GetAllExperienceDto>>() {}.getType());
        return new SuccessDataResult<>(experienceDtos);
    }
}
