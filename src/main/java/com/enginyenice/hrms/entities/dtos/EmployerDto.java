package com.enginyenice.hrms.entities.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto extends UserDto{

	@NotNull
	private String companyName;
	@NotNull
	@URL
	private String webSite;
	@NotNull
	private String phoneNumber;
}
