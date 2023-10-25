package com.ms.restaurants.restaurants_manager.repository;

import com.ms.restaurants.restaurants_manager.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // You can add custom queries here if needed
}
