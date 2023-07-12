package com.example.otus_project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name ="`order_items`")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    @JsonManagedReference
    private Engine engine;

    @Column(name="price")
    private float price;

    @Column(name = "count")
    private int count;

    public OrderItem(int id, Engine engine, float price, int count) {
        this.id = id;
        this.engine = engine;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order.getId() +
                ", engine=" + engine +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}


