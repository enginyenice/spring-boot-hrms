package com.enginyenice.hrms.entities.dtos.schools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSchoolDto {
    private  String name;
    private String episode;
    private String yearOfGraduation;
}
