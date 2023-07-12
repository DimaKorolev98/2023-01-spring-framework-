package com.example.otus_project.rest;

import com.example.otus_project.repositories.CustomerRepo;
import com.example.otus_project.repositories.OrderItemRepo;
import com.example.otus_project.repositories.OrderRepo;
import com.example.otus_project.rest.dto.OrderDto;
import com.example.otus_project.domain.Customer;
import com.example.otus_project.domain.Order;
import com.example.otus_project.domain.OrderItem;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class OrderController {
    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final OrderItemRepo orderItemRepo;

    public OrderController(OrderRepo orderRepo, CustomerRepo customerRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @PostMapping("/api/orders/new")
    @Transactional
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        Order newOrder = OrderDto.toObject(orderDto);
        List<OrderItem> orderItems = newOrder.getOrderItems();
        Customer user;
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            user = customerRepo.findByUserName(userDetails.getUsername());
            newOrder.setCustomer(user);
        } else {
            System.out.println("User did not auth");
        }
        newOrder = orderRepo.save(newOrder);
        for (OrderItem o : orderItems) {
            o.setOrder(newOrder);
            orderItemRepo.save(o);
        }
        return OrderDto.toDto(newOrder);
    }

    @GetMapping("/api/orders/my")
    public List<Order> getOrdersByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        List<Order> orders = new ArrayList<>();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            orders = orderRepo.findAllByCustomerId(customerRepo.findByUserName(userDetails.getUsername()).getId());
        } else {
            System.out.println("User did not auth");
        }
        return orders;
    }
}
