package com.enginyenice.hrms.entities.dtos.jobPositions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobPositionDto {
    private int id;
    private String name;
}
