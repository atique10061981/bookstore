// OrderService
package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CustomerRepository;
import com.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private BookRepository bookRepo;

    public Order placeOrder(Long customerId, List<Long> bookIds) {
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<Book> books = bookRepo.findAllById(bookIds);

        Order order = new Order();
        order.setCustomer(customer);
        order.setBooks(books);
        order.setOrderDate(LocalDateTime.now());

        return orderRepo.save(order);
    }

    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}