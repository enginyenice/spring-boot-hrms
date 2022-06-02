package com.enginyenice.hrms.entities.dtos;


import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto extends UserDto {
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Length(min = 11,max = 11,message = "Should be 11 characters of nationality number")
	private String nationalityNumber;
	@NotNull	
	private int yearOfBirth;
}
