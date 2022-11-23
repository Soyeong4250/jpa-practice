package com.jpa.practice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "book2")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45)
    private String name;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private Publisher publisher;
}
