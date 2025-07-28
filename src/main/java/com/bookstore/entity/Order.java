package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // Avoids conflict with SQL reserved keyword
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "order_books",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books = new ArrayList<>();
}
