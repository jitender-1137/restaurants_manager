package com.ms.restaurants.restaurants_manager.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuRequestDTO {
    @NotBlank
    private String menuName;
    @NotBlank
    private String description;

    // Getters and setters
}
