package com.enginyenice.hrms.entities.dtos.languages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageDto {
    private String name;
    private int level;
}
