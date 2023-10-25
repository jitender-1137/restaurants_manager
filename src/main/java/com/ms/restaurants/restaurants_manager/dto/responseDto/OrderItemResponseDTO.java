package com.ms.restaurants.restaurants_manager.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemResponseDTO {
    private Long orderItemId;
    private Long menuItemId;
    private String itemName;
    private int quantity;
    private double subtotal;

    // Getters and setters
}
