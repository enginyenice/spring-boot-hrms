package com.enginyenice.hrms.webApi.controllers;

import javax.validation.Valid;

import com.enginyenice.hrms.entities.dtos.candaidates.CandidateCoverLetterDto;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateSocialMediaDto;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateUploadImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enginyenice.hrms.bussines.abstracts.CandidateService;
import com.enginyenice.hrms.entities.dtos.candaidates.CandidateDto;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/candidate/")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody CandidateDto CandidateDto)
    {
        return ResponseEntity.ok(this.candidateService.create(CandidateDto));
    }
    @PutMapping("update-social-media")
    public ResponseEntity<?> updateSocialMedia(@Valid @RequestBody CandidateSocialMediaDto candidateSocialMediaDto)
    {
        return ResponseEntity.ok(this.candidateService.updateSocialMedia(candidateSocialMediaDto));
    }

    @PutMapping("update-cover-letter")
    public ResponseEntity<?> updateCoverLetter(@Valid @RequestBody CandidateCoverLetterDto candidateCoverLetterDto)
    {
        return ResponseEntity.ok(this.candidateService.updateCoverLetter(candidateCoverLetterDto));
    }

     @PostMapping("upload-image")
     public ResponseEntity<?> uploadImage(@RequestParam int id, @RequestParam MultipartFile imageUrl ){
         CandidateUploadImageDto uploadImageDto = new CandidateUploadImageDto();
         uploadImageDto.setImageUrl(imageUrl);
         uploadImageDto.setId(id);

         return ResponseEntity.ok(this.candidateService.uploadImage(uploadImageDto));
     }
    @GetMapping("get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateService.getAll());
    }

    @GetMapping("resume")
    public ResponseEntity<?> getResumeByCandidateId(@RequestParam int candidateId){
        return  ResponseEntity.ok(this.candidateService.getResumeByCandidateId(candidateId));
    }

}
