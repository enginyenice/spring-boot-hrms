package com.enginyenice.hrms.entities.dtos.jobAdvertisements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementDto {

    private String companyName;
    @NotNull
    private String jobPositionName;
    @NotNull
    private String cityName;
    @NotNull
    private double minimumSalary;
    @NotNull
    private double maximumSalary;
    @NotNull
    private String description;
    @NotNull
    private int piece;
    @NotNull
    private Date deadline;
}
