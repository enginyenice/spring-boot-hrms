package com.enginyenice.hrms.bussines.concretes;


import java.util.List;

import com.enginyenice.hrms.bussines.abstracts.CandidateService;
import com.enginyenice.hrms.core.utilities.fileOperations.FileUpload;
import com.enginyenice.hrms.core.utilities.results.*;
import com.enginyenice.hrms.entities.dtos.candaidates.*;
import com.enginyenice.hrms.entities.dtos.resumes.ResumeDto;
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

@Service
public class CandidateManager implements CandidateService {


    private final CandidateRepository candidateRepository;
    private final NationalityAuthanticationService nationalityAuthanticationService;
    private final UserService userService;
    private ModelMapper modelMapper;
    private final UserRules userRules;
    private final CandidateRules candidateRules;
    private final FileUpload fileUpload;

    public CandidateManager(
            CandidateRepository candidateRepository,
            UserRules userRules,
            @Qualifier("fakeService") NationalityAuthanticationService nationalityAuthanticationService,
            @Qualifier("cloudinary") FileUpload fileUpload,
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
        this.fileUpload= fileUpload;
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
    public Result updateSocialMedia(CandidateSocialMediaDto candidateSocialMediaDto) {
        Candidate candidate = this.candidateRepository.findById(candidateSocialMediaDto.getId()).get();
        candidate.setGithub(candidateSocialMediaDto.getGithub());
        candidate.setLinkedin(candidateSocialMediaDto.getLinkedin());
        this.candidateRepository.save(candidate);
        return new SuccessResult();
    }

    @Override
    public Result updateCoverLetter(CandidateCoverLetterDto candidateCoverLetterDto) {
        Candidate candidate = this.candidateRepository.findById(candidateCoverLetterDto.getId()).get();
        candidate.setCoverLetter(candidateCoverLetterDto.getCoverLetter());
        this.candidateRepository.save(candidate);
        return new SuccessResult();
    }

    @Override
    public Result uploadImage(CandidateUploadImageDto candidateUploadImageDto) {
        Candidate candidate = this.candidateRepository.findById(candidateUploadImageDto.getId()).get();
        String imageUrl = this.fileUpload.upload(candidateUploadImageDto.getImageUrl());
        candidate.setImageUrl(imageUrl);
        this.candidateRepository.save(candidate);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllCandidateDto>> getAll() {
		var result = this.candidateRepository.getAll();
		return new SuccessDataResult<List<GetAllCandidateDto>>(result);
    }

    @Override
    public DataResult<ResumeDto> getResumeByCandidateId(int candidateId) {
        Candidate candidate = this.candidateRepository.findById(candidateId).get();
        ResumeDto resume = this.modelMapper.map(candidate,ResumeDto.class);
        return new SuccessDataResult<>(resume);
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
