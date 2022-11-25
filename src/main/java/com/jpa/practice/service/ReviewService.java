package com.jpa.practice.service;

import com.jpa.practice.domain.dto.ReviewRequestDto;
import com.jpa.practice.domain.dto.ReviewResponseDto;
import com.jpa.practice.domain.entity.Hospital;
import com.jpa.practice.domain.entity.Review;
import com.jpa.practice.repository.HospitalRepository;
import com.jpa.practice.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return ReviewResponseDto.builder()
                .hospitalName(review.getHospital().getName())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .userName(savedReview.getUserName())
                .build();
    }

    public ReviewResponseDto getReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("%d 번의 리뷰가 없습니다.", id)));
        return ReviewResponseDto.fromEntity(review);
    }

    public List<ReviewResponseDto> getReviewList(Long hospitalId, Pageable pageable) {
        Hospital hospital = hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("해당 병원을 찾지 못했습니다."));
        Page<Review> reviewList = reviewRepository.findByHospital(hospital, pageable);
        List<ReviewResponseDto> reviewResponseList = reviewList.stream().map((review) -> {
            return ReviewResponseDto.fromEntity(review);
        }).collect(Collectors.toList());
        return reviewResponseList;
    }
}
