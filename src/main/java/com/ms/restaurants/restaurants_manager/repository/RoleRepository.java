package com.ms.restaurants.restaurants_manager.repository;

import com.ms.restaurants.restaurants_manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // You can add custom queries here if needed
}
