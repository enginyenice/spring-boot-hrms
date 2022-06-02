package com.enginyenice.hrms.entities.dtos.emailActivations;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailActivationDto {
	@NotNull()
	@NotEmpty()
	@Min(value = 0)
	private int userId;
	
	@NotNull()
	@NotEmpty()	
	private String code;
	
}
