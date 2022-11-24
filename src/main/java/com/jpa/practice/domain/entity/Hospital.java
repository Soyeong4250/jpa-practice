package com.jpa.practice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @OneToMany(mappedBy = "hospital")
    @OrderBy("id asc")
    private List<Review> reviewList;
}
