package com.enginyenice.hrms.bussines.abstracts;

import java.util.List;

import com.enginyenice.hrms.core.utilities.results.DataResult;
import com.enginyenice.hrms.core.utilities.results.Result;
import com.enginyenice.hrms.entities.concretes.Candidate;
import com.enginyenice.hrms.entities.dtos.candaidates.*;
import com.enginyenice.hrms.entities.dtos.resumes.ResumeDto;

public interface CandidateService {
    Result create(CandidateDto candidateDto);
    Result updateSocialMedia(CandidateSocialMediaDto candidateSocialMediaDto);
    Result updateCoverLetter(CandidateCoverLetterDto candidateCoverLetterDto);
    Result uploadImage(CandidateUploadImageDto candidateUploadImageDto);
    DataResult<List<GetAllCandidateDto>> getAll();

    DataResult<ResumeDto> getResumeByCandidateId(int candidateId);


}
