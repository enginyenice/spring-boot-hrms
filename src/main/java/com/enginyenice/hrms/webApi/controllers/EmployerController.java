package com.enginyenice.hrms.webApi.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enginyenice.hrms.bussines.abstracts.EmployerService;
import com.enginyenice.hrms.entities.dtos.employers.EmployerDto;

@RestController
@RequestMapping("/api/employer/")
public class EmployerController {

	private final EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@PostMapping("create")
	public ResponseEntity<?> Create(@Valid @RequestBody EmployerDto employerDto)
	{
		return ResponseEntity.ok(this.employerService.create(employerDto));
	}

	@GetMapping("get-all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.employerService.getAll());
	}
	
}
