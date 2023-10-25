package com.ms.restaurants.restaurants_manager.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequestDTO {
    @NotBlank
    private Long tableId;
    @NotBlank
    private List<OrderItemRequestDTO> items;

    // Getters and setters
}
