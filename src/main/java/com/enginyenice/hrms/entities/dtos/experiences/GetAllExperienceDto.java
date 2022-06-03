package com.enginyenice.hrms.entities.dtos.experiences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllExperienceDto {
    private String companyName;
    private String position;
    private String startYear;
    private String endYear;
}
