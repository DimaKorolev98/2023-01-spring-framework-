package com.example.otus_project.rest.dto;

import com.example.otus_project.domain.Engine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EngineDto {
    private int id;
    private ProducerDto producer;
    private String name;
    private float price;
    private String info;



    public static EngineDto toDto(Engine engine) {
        return new EngineDto(engine.getId(), ProducerDto.toDto(engine.getProducer()), engine.getName(), engine.getPrice(), engine.getInfo());
    }

    public static Engine toObject(EngineDto engineDto){
        return new Engine(engineDto.getId(), ProducerDto.toObject(engineDto.getProducer()), engineDto.getName(), engineDto.getPrice(), engineDto.getInfo());
    }

}
