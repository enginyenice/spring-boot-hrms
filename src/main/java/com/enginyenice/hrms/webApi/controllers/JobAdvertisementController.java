package com.enginyenice.hrms.webApi.controllers;

import com.enginyenice.hrms.bussines.abstracts.JobAdvertisementService;
import com.enginyenice.hrms.entities.dtos.jobAdvertisements.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/job-advertisement/")
public class JobAdvertisementController {
    private final JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody JobAdvertisementDto jobAdvertisementDto)
    {
        return ResponseEntity.ok(this.jobAdvertisementService.create(jobAdvertisementDto));
    }
    @GetMapping("get-all")
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(this.jobAdvertisementService.getAll());
    }

    @GetMapping("get-by-employer-id")
    public ResponseEntity<?> getAllByEmployerId(@RequestParam int employerId)
    {
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByEmployerId(employerId));
    }
}
