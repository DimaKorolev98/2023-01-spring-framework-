package com.example.otus_project.rest.dto;

import com.example.otus_project.domain.Producer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProducerDto {
    private int id;
    private String name;



    public static ProducerDto toDto(Producer producer) {
        return new ProducerDto(producer.getId(), producer.getName());
    }

    public static Producer toObject(ProducerDto producerDto){
        return  new Producer(producerDto.getId(), producerDto.getName());
    }
}
