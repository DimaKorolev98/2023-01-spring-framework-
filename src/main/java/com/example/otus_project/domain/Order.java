package com.example.otus_project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
@RequiredArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(name="order_date")
    private Date orderDate;


    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private String status;
    @Column(name = "status_date")
    private Date statusDate;

    public Order(int id, Date orderDate, List<OrderItem> orderItems, String paymentType, String deliveryType, String deliveryAddress, String comment, String status, Date statusDate) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        this.deliveryAddress = deliveryAddress;
        this.comment = comment;
        this.status = status;
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", paymentType='" + paymentType + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", statusDate=" + statusDate +
                '}';
    }
}
