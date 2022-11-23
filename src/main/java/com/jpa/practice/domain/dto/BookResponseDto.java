package com.jpa.practice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private Long id;
    private String name;
    private String authorName;
    private String publisherName;
}
