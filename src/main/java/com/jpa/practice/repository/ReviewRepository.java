package com.jpa.practice.repository;

import com.jpa.practice.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public List<Review> findByHospitalId(Long id);
}
