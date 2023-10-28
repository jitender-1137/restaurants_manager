package com.ms.restaurants.restaurants_manager.serviceImpl;

import com.ms.restaurants.restaurants_manager.dto.requestDto.TableRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.TableResponseDTO;
import com.ms.restaurants.restaurants_manager.entity.Table;
import com.ms.restaurants.restaurants_manager.repository.TableRepository;
import com.ms.restaurants.restaurants_manager.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Override
    public List<TableResponseDTO> getAllTables() {
        List<Table> tables = tableRepository.findAll();
        return tables.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TableResponseDTO getTableById(Long tableId) {
        Table table = tableRepository.findById(tableId)
                .orElseThrow(() -> new EntityNotFoundException("Table not found with id: " + tableId));
        return convertToResponseDTO(table);
    }

    @Override
    public TableResponseDTO createTable(TableRequestDTO tableRequestDTO) {
        Table table = new Table();
        table.setTableName(tableRequestDTO.getTableName());
        table.setCapacity(tableRequestDTO.getCapacity());
        table.setQrCode(tableRequestDTO.getQrCode());
        table.setStatus("available"); // Assuming a new table is always available
        table.setTableNo(tableRequestDTO.getTableNo());
        Table savedTable = tableRepository.save(table);
        return convertToResponseDTO(savedTable);
    }

    @Override
    public TableResponseDTO updateTable(Long tableId, TableRequestDTO tableRequestDTO) {
        Table table = tableRepository.findById(tableId)
                .orElseThrow(() -> new EntityNotFoundException("Table not found with id: " + tableId));

        table.setTableName(tableRequestDTO.getTableName());
        table.setCapacity(tableRequestDTO.getCapacity());
        table.setQrCode(tableRequestDTO.getQrCode());
        table.setTableNo(tableRequestDTO.getTableNo());

        Table updatedTable = tableRepository.save(table);
        return convertToResponseDTO(updatedTable);
    }

    @Override
    public void deleteTable(Long tableId) {
        tableRepository.deleteById(tableId);
    }

    private TableResponseDTO convertToResponseDTO(Table table) {
        TableResponseDTO responseDTO = new TableResponseDTO();
        responseDTO.setTableId(table.getTableId());
        responseDTO.setTableName(table.getTableName());
        responseDTO.setCapacity(table.getCapacity());
        responseDTO.setStatus(table.getStatus());
        responseDTO.setQrCode(table.getQrCode());
        responseDTO.setTableNo(table.getTableNo());
        return responseDTO;
    }
}
