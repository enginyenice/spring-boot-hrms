package com.enginyenice.hrms.entities.dtos.candaidates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateUploadImageDto {
    private int id;
    private MultipartFile imageUrl;
}
