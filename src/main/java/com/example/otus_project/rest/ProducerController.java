package com.example.otus_project.rest;


import com.example.otus_project.repositories.ProducerRepo;
import com.example.otus_project.rest.dto.ProducerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class ProducerController {

    private final ProducerRepo producerRepo;

    @GetMapping("/api/producers")
    public List<ProducerDto> getAllGenres() {
        return producerRepo.findAll().stream().map(ProducerDto::toDto)
                .collect(Collectors.toList());
    }
}
