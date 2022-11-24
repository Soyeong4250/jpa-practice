package com.jpa.practice.domain.entity;

import com.jpa.practice.domain.dto.ReviewResponseDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "review2")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 45)
    private String userName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public Review(String title, String content, String userName, Hospital hospital) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.hospital = hospital;
    }
}
