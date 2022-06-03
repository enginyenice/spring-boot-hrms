package com.enginyenice.hrms.entities.dtos.talents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentDto {
    @NotNull
    private String name;

    private int candidateId;
}
