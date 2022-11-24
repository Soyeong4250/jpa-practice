package com.jpa.practice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {

    private Long hospitalId;
    private String title;
    private String content;
    private String userName;
}
