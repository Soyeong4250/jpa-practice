package com.jpa.practice.repository;

import com.jpa.practice.domain.entity.Hospital;
import com.jpa.practice.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByHospital(Hospital hospital, Pageable pageable);

    Long countByHospitalId(Long id);
}
