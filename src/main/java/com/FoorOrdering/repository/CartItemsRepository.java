package com.FoorOrdering.repository;

import com.FoorOrdering.model.Cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {
}
