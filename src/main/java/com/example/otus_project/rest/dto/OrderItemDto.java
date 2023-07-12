package com.example.otus_project.rest.dto;

import com.example.otus_project.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private int id;
    private EngineDto engineDto;
    private float price;
    private int count;

    public static OrderItemDto toDto(OrderItem orderItem){
        return new OrderItemDto(orderItem.getId(),
                EngineDto.toDto(orderItem.getEngine()), orderItem.getPrice(), orderItem.getCount());

    }

    public static OrderItem toObject(OrderItemDto orderItemDto){
        return new OrderItem(orderItemDto.getId(),
                EngineDto.toObject(orderItemDto.getEngineDto()), orderItemDto.getPrice(), orderItemDto.getCount());
    }
}
