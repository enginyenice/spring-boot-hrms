package com.enginyenice.hrms.entities.dtos.languages;

import com.enginyenice.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    private String name;
    private int level;
    private int candidateId;
}
