package com.example.otus_project.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name ="`producers`")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;



    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
