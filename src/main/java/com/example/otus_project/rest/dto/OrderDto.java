package com.example.otus_project.rest.dto;


import com.example.otus_project.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
public class OrderDto {
    private int id;
    private Date orderDate;
    private List<OrderItemDto> orderItems;
    private String paymentType;
    private String deliveryType;
    private String deliveryAddress;
    private String comment;
    private String status;
    private Date statusDate;


    public static OrderDto toDto(Order order) {
      return new OrderDto(order.getId(),
              order.getOrderDate(),
              order.getOrderItems().stream().map(OrderItemDto::toDto).collect(Collectors.toList()),
              order.getPaymentType(),
              order.getDeliveryType(),
              order.getDeliveryAddress(),
              order.getComment(),
              order.getStatus(),
              order.getStatusDate());
    }

    public static Order toObject(OrderDto orderDto){
        return new Order(orderDto.getId(),
                orderDto.getOrderDate(),
                orderDto.getOrderItems().stream().map(OrderItemDto::toObject).collect(Collectors.toList()),
                orderDto.getPaymentType(),
                orderDto.getDeliveryType(),
                orderDto.getDeliveryAddress(),
                orderDto.getComment(),
                orderDto.getStatus(),
                orderDto.getStatusDate());
    }

}
