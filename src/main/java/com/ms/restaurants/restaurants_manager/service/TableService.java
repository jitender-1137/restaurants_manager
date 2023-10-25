package com.ms.restaurants.restaurants_manager.service;

import com.ms.restaurants.restaurants_manager.dto.requestDto.TableRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.TableResponseDTO;

import java.util.List;

public interface TableService {

    List<TableResponseDTO> getAllTables();

    TableResponseDTO getTableById(Long tableId);

    TableResponseDTO createTable(TableRequestDTO tableRequestDTO);

    TableResponseDTO updateTable(Long tableId, TableRequestDTO tableRequestDTO);

    void deleteTable(Long tableId);
}
