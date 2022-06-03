package com.enginyenice.hrms.webApi.controllers;


import com.enginyenice.hrms.bussines.abstracts.TalentService;
import com.enginyenice.hrms.entities.dtos.talents.TalentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/talent/")
public class TalentController {
    private final TalentService talentService;


    public TalentController(TalentService talentService) {
        this.talentService = talentService;
    }
    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody TalentDto talentDto)
    {
        return ResponseEntity.ok(this.talentService.create(talentDto));
    }
    @GetMapping(name= "get-by-candidate-id")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.talentService.getByCandidateId(candidateId));
    }

}