package com.enginyenice.hrms.webApi.controllers;

import com.enginyenice.hrms.bussines.abstracts.CityService;
import com.enginyenice.hrms.entities.dtos.cities.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/city/")
public class CityController {
    private final CityService cityService;


    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody CityDto cityDto)
    {
        return ResponseEntity.ok(this.cityService.create(cityDto));
    }
    @GetMapping("getAll")
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(this.cityService.getAll());
    }

}
