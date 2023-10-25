package com.ms.restaurants.restaurants_manager.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemRequestDTO {

    @NotBlank
    private String itemName;
    @NotBlank
    private String description;
    @NotBlank
    private double price;
    @NotBlank
    private String category;

}
