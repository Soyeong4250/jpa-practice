package com.jpa.practice.controller;

import com.jpa.practice.domain.dto.HospitalResponseDto;
import com.jpa.practice.domain.dto.ReviewRequestDto;
import com.jpa.practice.domain.dto.ReviewResponseDto;
import com.jpa.practice.service.HospitalService;
import com.jpa.practice.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
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

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponseDto>> getReviewByHospital(@PathVariable Long id, @PageableDefault(size = 10) Pageable pageable) {
        List<ReviewResponseDto> reviewResponseList = reviewService.getReviewList(id, pageable);
        return ResponseEntity.ok().body(reviewResponseList);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponseDto> addReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        log.info("{}", reviewRequestDto);
        return ResponseEntity.ok().body(reviewService.add(reviewRequestDto));
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable Long id) {
        ReviewResponseDto reviewResponseDto = reviewService.getReview(id);
        return ResponseEntity.ok().body(reviewResponseDto);
    }
}
