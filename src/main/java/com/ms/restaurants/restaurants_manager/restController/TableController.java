package com.ms.restaurants.restaurants_manager.restController;

import com.ms.restaurants.restaurants_manager.dto.requestDto.TableRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.ResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.SuccessResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.TableResponseDTO;
import com.ms.restaurants.restaurants_manager.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public ResponseDto<?> getAllTables() {
        List<TableResponseDTO> tables = tableService.getAllTables();
        return new SuccessResponseDto(tables, HttpStatus.OK);
    }

    @GetMapping("/{tableId}")
    public ResponseDto<?> getTableById(@PathVariable Long tableId) {
        TableResponseDTO table = tableService.getTableById(tableId);
        return new SuccessResponseDto(table, HttpStatus.OK);
    }

    @PostMapping
    public ResponseDto<?> createTable(@RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO createdTable = tableService.createTable(tableRequestDTO);
        return new SuccessResponseDto(createdTable, HttpStatus.CREATED);
    }

    @PutMapping("/{tableId}")
    public ResponseDto<?> updateTable(@PathVariable Long tableId, @RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO updatedTable = tableService.updateTable(tableId, tableRequestDTO);
        return new SuccessResponseDto(updatedTable, HttpStatus.OK);
    }

    @DeleteMapping("/{tableId}")
    public ResponseDto<?> deleteTable(@PathVariable Long tableId) {
        tableService.deleteTable(tableId);
        return new SuccessResponseDto(HttpStatus.NO_CONTENT);
    }
}
