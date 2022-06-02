package com.enginyenice.hrms.entities.dtos.jobAdvertisements;

import com.enginyenice.hrms.entities.concretes.City;
import com.enginyenice.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

    @NotNull
    private int jobPositionId;
    @NotNull
    private int cityId;
    @NotNull
    private int employerId;
    @NotNull
    private double minimumSalary;
    @NotNull
    private double maximumSalary;
    @NotNull
    private String description;
    @NotNull
    private int piece;

    private Date deadline;
}
