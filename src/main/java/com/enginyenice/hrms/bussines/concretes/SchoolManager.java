package com.enginyenice.hrms.bussines.concretes;

import com.enginyenice.hrms.bussines.abstracts.SchoolService;
import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.core.utilities.results.SuccessDataResult;
import com.enginyenice.hrms.core.utilities.results.SuccessResult;
import com.enginyenice.hrms.dataAccess.abstracts.SchoolRepository;
import com.enginyenice.hrms.entities.concretes.School;
import com.enginyenice.hrms.entities.dtos.schools.GetAllSchoolDto;
import com.enginyenice.hrms.entities.dtos.schools.SchoolDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolRepository schoolRepository;
    private ModelMapper modelMapper;

    public SchoolManager(SchoolRepository schoolRepository, ModelMapper modelMapper) {
        this.schoolRepository = schoolRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result create(SchoolDto schoolDto) {
        School school = this.modelMapper.map(schoolDto, School.class);
        school.setId(0);
        if(school.getYearOfGraduation().isEmpty())
        {
            school.setYearOfGraduation("Devam ediyor");
        }
        var result = this.schoolRepository.save(school);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllSchoolDto>> getByCandidateId(int candidateId) {
        List<GetAllSchoolDto> schoolDtos =
                this.modelMapper.map(
                                        this.schoolRepository.getByCandidate_IdOrderByYearOfGraduationDesc(candidateId),
                                        new TypeToken<List<GetAllSchoolDto>>() {}.getType());
        return new SuccessDataResult<>(schoolDtos);

    }
}
