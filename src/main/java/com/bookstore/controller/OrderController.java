// OrderController
package com.bookstore.controller;
import com.bookstore.dto.OrderDTO;
import com.bookstore.entity.Order;
import com.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order place(@RequestBody OrderDTO dto) {
        return orderService.placeOrder(dto.getCustomerId(), dto.getBookIds());
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrders(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }
}
