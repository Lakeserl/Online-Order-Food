package com.FoorOrdering.repository;

import com.FoorOrdering.model.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
