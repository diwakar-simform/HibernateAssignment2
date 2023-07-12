package com.hibernate.AssignmentTwo.entities.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hibernate.AssignmentTwo.entities.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReviewRating rating;

    @Column(nullable = false)
    private String description;


    @JsonIgnore
    @ManyToOne
    private Course course;
}
