package com.ms.restaurants.restaurants_manager.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemRequestDTO {
    @NotBlank
    private Long menuItemId;
    @NotBlank
    private int quantity;

    // Getters and setters
}
