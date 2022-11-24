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

    public HospitalResponseDto(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private List<Review> reviewList = new ArrayList<>();
}
