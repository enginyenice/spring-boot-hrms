package com.enginyenice.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllEmployerDto {
    private String email;
    private String companyName;
    private String webSite;
    private String phoneNumber;
}
