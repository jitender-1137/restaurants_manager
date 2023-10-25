package com.ms.restaurants.restaurants_manager.repository;

import com.ms.restaurants.restaurants_manager.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    // You can add custom queries here if needed
}
