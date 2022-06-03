package com.enginyenice.hrms.entities.dtos.candaidates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSocialMediaDto {
    private int id;
    private String github;
    private String linkedin;
}
