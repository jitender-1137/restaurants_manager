package com.ms.restaurants.restaurants_manager.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TableResponseDTO {
    private Long tableId;
    private String tableName;
    private int capacity;
    private String status; // occupied, available
    private String qrCode;

    // Getters and setters
}
