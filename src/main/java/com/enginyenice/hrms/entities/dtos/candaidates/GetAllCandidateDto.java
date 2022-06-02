package com.enginyenice.hrms.entities.dtos.candaidates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCandidateDto {
	private String email;
	private String firstName;
	private String lastName;
	private String nationalityNumber;
	private int yearOfBirth;
}
