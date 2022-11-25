package com.jpa.practice.controller;

import com.jpa.practice.domain.dto.HospitalResponseDto;
import com.jpa.practice.domain.dto.ReviewRequestDto;
import com.jpa.practice.domain.dto.ReviewResponseDto;
import com.jpa.practice.service.HospitalService;
import com.jpa.practice.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalRestController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @ApiOperation(value = "병원 전체 리스트 조회", notes = "GET Method")
    @GetMapping()
    public List<HospitalResponseDto> getHospitalList() {
        List<HospitalResponseDto> hospitalList = hospitalService.getHospitalList();
        return hospitalList;
    }

    @ApiOperation(value = "특정 병원 상세정보 조회", notes = "@PathVariable을 활용한 GET Method")
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponseDto> getHospital(@PathVariable Long id) {
        HospitalResponseDto hospitalResponseDto = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponseDto);
    }

    @ApiOperation(value = "특정 병원의 모든 댓글 조회", notes = "@PathVariable을 활용한 GET Method")
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponseDto>> getReviewByHospital(@PathVariable Long id, @PageableDefault(size = 10) Pageable pageable) {
        List<ReviewResponseDto> reviewResponseList = reviewService.getReviewList(id, pageable);
        return ResponseEntity.ok().body(reviewResponseList);
    }

    @ApiOperation(value = "댓글 등록", notes = "@RequestBody를 활용한 POST Method")
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponseDto> addReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        log.info("{}", reviewRequestDto);
        return ResponseEntity.ok().body(reviewService.add(reviewRequestDto));
    }

}
