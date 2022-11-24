package com.jpa.practice.controller;

import com.jpa.practice.domain.dto.HospitalResponseDto;
import com.jpa.practice.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping()
    public List<HospitalResponseDto> getHospitalList() {
        List<HospitalResponseDto> hospitalList = hospitalService.getHospitalList();
        return hospitalList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponseDto> getHospital(@PathVariable Long id) {
        HospitalResponseDto hospitalResponseDto = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponseDto);
    }
}
