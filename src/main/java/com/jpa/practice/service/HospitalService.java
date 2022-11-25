package com.jpa.practice.service;

import com.jpa.practice.domain.dto.HospitalResponseDto;
import com.jpa.practice.domain.entity.Hospital;
import com.jpa.practice.repository.HospitalRepository;
import com.jpa.practice.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }
    public List<HospitalResponseDto> getHospitalList() {
        List<Hospital> hospitalList = hospitalRepository.findAll();
        List<HospitalResponseDto> hospitalResponseList = hospitalList.stream().map((hospital) -> {
           return HospitalResponseDto.builder()
                   .id(hospital.getId())
                   .name(hospital.getName())
                   .address(hospital.getAddress())
                   .reviewCnt(reviewRepository.countByHospitalId(hospital.getId()))
                   .message("병원 조회 성공")
                   .build();
        }).collect(Collectors.toList());

        return hospitalResponseList;
    }



    public HospitalResponseDto getHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id).get();
        log.info("reviewList.size() : {}", hospital.getReviewList().size());
        return HospitalResponseDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .address(hospital.getAddress())
                .message("병원 조회 성공")
                .build();
    }

}
