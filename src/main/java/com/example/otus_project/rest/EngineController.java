package com.example.otus_project.rest;


import com.example.otus_project.repositories.EngineRepo;
import com.example.otus_project.rest.dto.EngineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class EngineController {

    private final EngineRepo engineRepo;

    @GetMapping("/api/engines")
    public List<EngineDto> getAllEngines() {
        return engineRepo.findAll().stream()
                .map(EngineDto::toDto)
                .collect(Collectors.toList());
    }
}
