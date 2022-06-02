package com.enginyenice.hrms.webApi.controllers;

import com.enginyenice.hrms.entities.dtos.JobPositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enginyenice.hrms.bussines.abstracts.JobPositionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/job-positions/")
public class JobPositionController {

	private final JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("get-all")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobPositionService.getAll());
	}

	@PostMapping("create")
	public ResponseEntity<?> create(@Valid @RequestBody JobPositionDto jobPositionDto) {
		return ResponseEntity.ok(this.jobPositionService.create(jobPositionDto));
	}
}
