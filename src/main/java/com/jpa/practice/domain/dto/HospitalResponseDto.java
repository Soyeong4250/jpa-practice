package com.jpa.practice.domain.dto;

import com.jpa.practice.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponseDto {
    private Long id;
    private String name;
    private String address;

    private List<Review> reviewList = new ArrayList<>();
}
