package com.example.simplecrud.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String description;
    @Column(name = "year_of_publication")
    private String yearOfPublication;
}
