package com.example.otus_project.rest;

import com.example.otus_project.repositories.OrderItemRepo;
import com.example.otus_project.rest.dto.OrderItemDto;
import com.example.otus_project.domain.OrderItem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemsController {
    private final OrderItemRepo orderItemRepo;

    public OrderItemsController(OrderItemRepo orderItemRepo) {
        this.orderItemRepo = orderItemRepo;
    }

    @PostMapping("/api/items/new")
    public OrderItemDto createOrderItem(@RequestBody OrderItemDto orderItemDto){
        OrderItem orderItem = OrderItemDto.toObject(orderItemDto);
        orderItemRepo.save(orderItem);
        return OrderItemDto.toDto(orderItem);
    }

}
