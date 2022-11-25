package com.jpa.practice.domain.dto;

import com.jpa.practice.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDto {
    private String hospitalName;
    private String title;
    private String content;
    private String userName;

    public static ReviewResponseDto fromEntity(Review review) {
        return ReviewResponseDto.builder()
                .hospitalName(review.getHospital().getName())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .build();
    }
}
