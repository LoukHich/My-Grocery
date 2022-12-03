package com.ensah.mygroceryapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "registre")
public class Registre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    CourseList course;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    LocalDateTime registeredAt;

    String Note;
}
