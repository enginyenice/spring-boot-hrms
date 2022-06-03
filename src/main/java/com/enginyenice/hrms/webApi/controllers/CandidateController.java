package com.enginyenice.hrms.webApi.controllers;

import javax.validation.Valid;

import com.enginyenice.hrms.entities.dtos.candaidates.CandidateCoverLetterDto;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateSocialMediaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enginyenice.hrms.bussines.abstracts.CandidateService;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateDto;

@RestController
@RequestMapping("/api/candidate/")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody CandidateDto CandidateDto)
    {
        return ResponseEntity.ok(this.candidateService.create(CandidateDto));
    }
    @PutMapping("update-social-media")
    public ResponseEntity<?> updateSocialMedia(@Valid @RequestBody CandidateSocialMediaDto candidateSocialMediaDto)
    {
        return ResponseEntity.ok(this.candidateService.updateSocialMedia(candidateSocialMediaDto));
    }

    @PutMapping("update-cover-letter")
    public ResponseEntity<?> updateCoverLetter(@Valid @RequestBody CandidateCoverLetterDto candidateCoverLetterDto)
    {
        return ResponseEntity.ok(this.candidateService.updateCoverLetter(candidateCoverLetterDto));
    }
    @GetMapping("get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateService.getAll());
    }

}
