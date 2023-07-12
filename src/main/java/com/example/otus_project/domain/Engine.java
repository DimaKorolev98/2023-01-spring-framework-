package com.example.otus_project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name ="`items`")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producer_id")
    @JsonManagedReference
    private Producer producer;

    @Column(name = "name")
    private String name;

    @Column(name="price")
    private float price;

    @Column(name="info")
    private String info;


    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", producer=" + producer +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                '}';
    }
}
