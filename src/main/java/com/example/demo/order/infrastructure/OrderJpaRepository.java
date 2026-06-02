package com.example.demo.order.infrastructure;

import com.example.demo.order.domain.model.Order;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {

}
