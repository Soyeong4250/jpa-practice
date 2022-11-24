package com.jpa.practice.service;

import com.jpa.practice.domain.dto.ReviewRequestDto;
import com.jpa.practice.domain.dto.ReviewResponseDto;
import com.jpa.practice.domain.entity.Hospital;
import com.jpa.practice.domain.entity.Review;
import com.jpa.practice.repository.HospitalRepository;
import com.jpa.practice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;


    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewResponseDto add(ReviewRequestDto dto) {
        Optional<Hospital> hospital = hospitalRepository.findById(dto.getHospitalId());
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .userName(dto.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponseDto(savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(),"리뷰 등록 성공");
    }
}
