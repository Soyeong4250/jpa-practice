package com.jpa.practice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital2")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hospital {
    @Id
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    @OrderBy("id asc")
    private List<Review> reviewList;

    @Builder
    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
