package com.jpa.practice.service;

import com.jpa.practice.domain.dto.HospitalResponseDto;
import com.jpa.practice.domain.entity.Hospital;
import com.jpa.practice.domain.entity.Review;
import com.jpa.practice.repository.HospitalRepository;
import com.jpa.practice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public HospitalResponseDto getHospital(Long id) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        List<Review> reviewList = reviewRepository.findByHospitalId(id);
        return new HospitalResponseDto(optHospital.get().getId(), optHospital.get().getName(), optHospital.get().getAddress(), reviewList);
    }
}
