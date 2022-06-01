package com.enginyenice.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enginyenice.hrms.bussines.abstracts.JobPositionService;
import com.enginyenice.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job-positions/")
public class JobPositionController {

	private final JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("get-all")
	public List<JobPosition> getAll() {
		return this.jobPositionService.getAll();
	}
	
}
