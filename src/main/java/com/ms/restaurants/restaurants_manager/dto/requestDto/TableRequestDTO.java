package com.ms.restaurants.restaurants_manager.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TableRequestDTO {
    @NotBlank
    private String tableName;
    @NotBlank
    private int capacity;
    @NotBlank
    private String qrCode;

    @NotBlank
    private String tableNo;

}
