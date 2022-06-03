package com.enginyenice.hrms.entities.dtos.schools;

import com.enginyenice.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private  String name;
    private String episode;
    private String yearOfGraduation;
    private int candidateId;
}
