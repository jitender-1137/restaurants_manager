package com.ms.restaurants.restaurants_manager.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemResponseDTO {
    private Long itemId;
    private String itemName;
    private String description;
    private double price;
    private String category;

    // Getters and setters
}
