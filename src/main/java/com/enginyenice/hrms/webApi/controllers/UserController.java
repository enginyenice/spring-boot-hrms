package com.enginyenice.hrms.webApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enginyenice.hrms.bussines.abstracts.UserService;
import com.enginyenice.hrms.entities.dtos.EmailActivationDto;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("email-verification")
	public ResponseEntity<?> emailActivation(@RequestParam String code, @RequestParam int userId)
	{
		EmailActivationDto emailActivationDto = EmailActivationDto.builder().userId(userId).code(code).build();
		return ResponseEntity.ok(this.userService.emailActivator(emailActivationDto));
	}
}
