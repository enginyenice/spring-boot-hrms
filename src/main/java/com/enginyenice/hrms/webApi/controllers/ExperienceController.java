package com.enginyenice.hrms.webApi.controllers;

import com.enginyenice.hrms.bussines.abstracts.ExperienceService;
import com.enginyenice.hrms.entities.dtos.experiences.ExperienceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/experience/")
@RestController
public class ExperienceController {
    private final ExperienceService experienceService;


    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }
    @PostMapping(name="create")
    public ResponseEntity<?> create(@Valid @RequestBody ExperienceDto experienceDto)
    {
        return ResponseEntity.ok(this.experienceService.create(experienceDto));
    }

    @GetMapping(name= "get-by-candidate-id")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.experienceService.getByCandidateId(candidateId));
    }
}
