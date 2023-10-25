package com.ms.restaurants.restaurants_manager.dto.responseDto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponseDTO {
    private Long orderId;
    private Long tableId;
    private List<OrderItemResponseDTO> items;
    private String status; // pending, completed
    private double totalPrice;
    private LocalDateTime orderTime;

    // Getters and setters
}
