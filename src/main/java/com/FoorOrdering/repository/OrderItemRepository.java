package com.FoorOrdering.repository;

import com.FoorOrdering.model.Order.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long> {

}
