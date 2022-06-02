package com.enginyenice.hrms.bussines.concretes;


import java.util.List;

import com.enginyenice.hrms.bussines.abstracts.CandidateService;
import com.enginyenice.hrms.core.utilities.results.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.enginyenice.hrms.bussines.abstracts.UserService;
import com.enginyenice.hrms.bussines.rules.CandidateRules;
import com.enginyenice.hrms.bussines.rules.UserRules;
import com.enginyenice.hrms.bussines.services.mernis.NationalityAuthanticationService;
import com.enginyenice.hrms.core.utilities.rules.BusinessRules;
import com.enginyenice.hrms.dataAccess.abstracts.CandidateRepository;
import com.enginyenice.hrms.entities.concretes.Candidate;
import com.enginyenice.hrms.entities.concretes.User;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateDto;
import com.enginyenice.hrms.entities.dtos.candaidates.GetAllCandidateDto;

@Service
public class CandidateManager implements CandidateService {


    private final CandidateRepository candidateRepository;
    private final NationalityAuthanticationService nationalityAuthanticationService;
    private final UserService userService;
    private ModelMapper modelMapper;
    private final UserRules userRules;
    private final CandidateRules candidateRules;

    public CandidateManager(
            CandidateRepository candidateRepository,
            UserRules userRules,
            @Qualifier("fakeService") NationalityAuthanticationService nationalityAuthanticationService,
            UserService userService,
            CandidateRules candidateRules,
            ModelMapper modelMapper)
    {
        this.userService = userService;
        this.nationalityAuthanticationService = nationalityAuthanticationService;
        this.candidateRepository = candidateRepository;
        this.userRules = userRules;
        this.candidateRules = candidateRules;
        this.modelMapper = modelMapper;
    }



    @Override
    public Result create(CandidateDto candidateDto) {

        Result res = BusinessRules.run(
                verifyNationalityNumber(candidateDto),
                this.userRules.IsExistEmail(candidateDto.getEmail()),
                this.candidateRules.IsExistNationalityNumber(candidateDto.getNationalityNumber()));

        if(!res.getSuccess())
        {
            return res;
        }

        User user = modelMapper.map(candidateDto, User.class);
        user.setCandidate(null);
        user.setEmailVerification(false);
        var userData = this.userService.create(user);


        if(!userData.getSuccess())
        {
            return new ErrorResult("User not created");
        }

        Candidate candidate = modelMapper.map(candidateDto, Candidate.class);
        candidate.setUser(userData.getData());
        candidateRepository.save(candidate);



        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllCandidateDto>> getAll() {
		var result = this.candidateRepository.getAll();
		return new SuccessDataResult<List<GetAllCandidateDto>>(result);
    }



    private Result verifyNationalityNumber(CandidateDto candidateDto)
    {
        boolean verify = this.nationalityAuthanticationService
                .verify(candidateDto.getNationalityNumber(),
                        candidateDto.getFirstName(),
                        candidateDto.getLastName(),
                        candidateDto.getYearOfBirth());
        if(!verify)
        {
            return new ErrorResult("Nationality Check is error");
        }
        return new SuccessResult();
    }
}
