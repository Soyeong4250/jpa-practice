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
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .userName(savedReview.getUserName())
                .message("리뷰 등록 성공")
                .build();
    }

    public ReviewResponseDto getReview(Long id) {
        Review review = reviewRepository.findById(id).get();
        return ReviewResponseDto.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .message("리뷰 조회 성공")
                .build();
    }

    public List<ReviewResponseDto> getReviewList(Long id, Pageable pageable) {
        Page<Review> reviewList = reviewRepository.findByHospitalId(id, pageable);
        List<ReviewResponseDto> reviewResponseList = reviewList.stream().map((review) -> {
            return ReviewResponseDto.builder()
                    .title(review.getTitle())
                    .content(review.getContent())
                    .userName(review.getUserName())
                    .message("리뷰 조회 성공")
                    .build();
        }).collect(Collectors.toList());
        return reviewResponseList;
    }
}
