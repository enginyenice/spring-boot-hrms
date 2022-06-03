package com.enginyenice.hrms.entities.dtos.experiences;

import com.enginyenice.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {

    @NotEmpty
    @NotNull
    private String companyName;

    @NotEmpty
    @NotNull
    private String position;

    @NotEmpty
    @NotNull
    private String startYear;

    private String endYear;

    @NotNull
    private int candidateId;
}
