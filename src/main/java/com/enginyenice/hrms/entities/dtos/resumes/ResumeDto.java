package com.enginyenice.hrms.entities.dtos.resumes;

import com.enginyenice.hrms.entities.dtos.experiences.GetAllExperienceDto;
import com.enginyenice.hrms.entities.dtos.languages.GetAllLanguageDto;
import com.enginyenice.hrms.entities.dtos.schools.GetAllSchoolDto;
import com.enginyenice.hrms.entities.dtos.talents.GetAllTalentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private String email;
    private String firstName;
    private String lastName;
    private String nationalityNumber;
    private int yearOfBirth;
    private String github;
    private String linkedin;
    private String imageUrl;

    private List<GetAllExperienceDto> experiences;
    private List<GetAllLanguageDto> languages;
    private List<GetAllSchoolDto> schools;
    private List<GetAllTalentDto> talents;
}
