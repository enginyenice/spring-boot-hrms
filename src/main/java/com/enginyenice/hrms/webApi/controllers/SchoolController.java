package com.enginyenice.hrms.webApi.controllers;

import com.enginyenice.hrms.bussines.abstracts.SchoolService;
import com.enginyenice.hrms.entities.dtos.schools.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/school/")
public class SchoolController {
    private final SchoolService schoolService;
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping(name="create")
    public ResponseEntity<?> create(@Valid @RequestBody SchoolDto schoolDto)
    {
        return ResponseEntity.ok(this.schoolService.create(schoolDto));
    }

    @GetMapping(name= "get-by-candidate-id")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.schoolService.getByCandidateId(candidateId));
    }
}
