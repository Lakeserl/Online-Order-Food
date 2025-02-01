package com.FoorOrdering.model;

import com.FoorOrdering.DTO.RestaurantDTO;
import com.FoorOrdering.model.Order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String fullName;

    private String email;

    private String password;

    private USER_ROLES role=USER_ROLES.ROLE_CUSTOMER;
// Thêm getter fix bugs
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public USER_ROLES getRole() {
        return role;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDTO> favourite = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

}
