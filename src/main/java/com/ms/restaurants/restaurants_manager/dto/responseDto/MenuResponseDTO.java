package com.ms.restaurants.restaurants_manager.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuResponseDTO {
    private Long menuId;
    private String menuName;
    private String description;

    // Getters and setters
}
