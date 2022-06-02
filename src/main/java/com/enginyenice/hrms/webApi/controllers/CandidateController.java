package com.enginyenice.hrms.webApi.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enginyenice.hrms.bussines.abstracts.CandidateService;
import com.enginyenice.hrms.entities.dtos.CandidateDto;

@RestController
@RequestMapping("/api/candidate/")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("create")
    public ResponseEntity<?> Create(@Valid @RequestBody CandidateDto CandidateDto)
    {
        return ResponseEntity.ok(this.candidateService.create(CandidateDto));
    }
    @GetMapping("get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateService.getAll());
    }

}
