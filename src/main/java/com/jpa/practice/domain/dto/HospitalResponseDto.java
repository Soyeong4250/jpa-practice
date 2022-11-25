package com.jpa.practice.domain.dto;

import com.jpa.practice.domain.entity.Hospital;
import com.jpa.practice.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalResponseDto {
    private Long id;
    private String name;
    private String address;
    private List<ReviewResponseDto> reviews;

    public static HospitalResponseDto fromEntity(Hospital hospital) {
        return HospitalResponseDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .address(hospital.getAddress())
                .reviews(hospital.getReviewList().stream()
                        .map(review -> ReviewResponseDto.fromEntity(review))
                        .collect(Collectors.toList()))
                .build();
    }
}
