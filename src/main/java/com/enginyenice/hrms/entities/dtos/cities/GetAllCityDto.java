package com.enginyenice.hrms.entities.dtos.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCityDto {
    private int id;
    @NotNull
    private String name;
}