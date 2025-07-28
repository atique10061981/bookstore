package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;  // Requires Author.java

    @ManyToMany(mappedBy = "books")
    private List<Order> orders = new ArrayList<>();
}
