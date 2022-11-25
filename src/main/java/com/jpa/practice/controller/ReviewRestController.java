package com.jpa.practice.controller;

import com.jpa.practice.domain.dto.ReviewResponseDto;
import com.jpa.practice.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @ApiOperation(value = "특정 댓글 상세정보 조회", notes = "@PathVariable을 활용한 GET Method")
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable Long id) {
        ReviewResponseDto reviewResponseDto = reviewService.getReview(id);
        return ResponseEntity.ok().body(reviewResponseDto);
    }
}
