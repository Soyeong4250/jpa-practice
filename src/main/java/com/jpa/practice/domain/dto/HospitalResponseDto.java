package com.jpa.practice.domain.dto;

import com.jpa.practice.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalResponseDto {
    private Long id;
    private String name;
    private String address;
    private String message;
}
