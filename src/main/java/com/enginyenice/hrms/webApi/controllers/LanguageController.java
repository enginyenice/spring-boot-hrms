package com.enginyenice.hrms.webApi.controllers;

import com.enginyenice.hrms.bussines.abstracts.LanguageService;
import com.enginyenice.hrms.entities.dtos.languages.LanguageDto;
import com.enginyenice.hrms.entities.dtos.schools.SchoolDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/language/")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping(name="create")
    public ResponseEntity<?> create(@Valid @RequestBody LanguageDto languageDto)
    {
        return ResponseEntity.ok(this.languageService.create(languageDto));
    }

    @GetMapping(name= "get-by-candidate-id")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.languageService.getByCandidateId(candidateId));
    }
}
