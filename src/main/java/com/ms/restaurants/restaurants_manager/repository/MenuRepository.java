package com.ms.restaurants.restaurants_manager.repository;

import com.ms.restaurants.restaurants_manager.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // You can add custom queries here if needed
}
