package com.enginyenice.hrms.entities.dtos.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	@Email
	@NotNull()
	@NotEmpty()
	private String email;
	@NotNull
	@NotEmpty()
	@Length(min = 6,max = 36)
	private String password;
}
