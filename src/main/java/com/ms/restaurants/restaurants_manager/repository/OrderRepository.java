package com.ms.restaurants.restaurants_manager.repository;

import com.ms.restaurants.restaurants_manager.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom queries here if needed
}
