package com.FoorOrdering.model.Order;


import com.FoorOrdering.model.Address;
import com.FoorOrdering.model.Restaurant;
import com.FoorOrdering.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User customer;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private Long totalAmount;

    private String orderStatus;

    private Date createAt;

    @ManyToOne
    private Address deliveryAddress;

    @OneToMany
    private List<OrderItems> items;

//    private Payment payment;

    private int totalItems;

    private double totalPrices;
}
