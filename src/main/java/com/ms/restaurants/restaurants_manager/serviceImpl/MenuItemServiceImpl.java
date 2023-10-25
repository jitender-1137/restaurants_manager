package com.ms.restaurants.restaurants_manager.serviceImpl;

import com.ms.restaurants.restaurants_manager.dto.requestDto.MenuItemRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.MenuItemResponseDTO;
import com.ms.restaurants.restaurants_manager.entity.MenuItem;
import com.ms.restaurants.restaurants_manager.repository.MenuItemRepository;
import com.ms.restaurants.restaurants_manager.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItemResponseDTO> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        return menuItems.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MenuItemResponseDTO getMenuItemById(Long itemId) {
        MenuItem menuItem = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Menu item not found with id: " + itemId));
        return convertToResponseDTO(menuItem);
    }

    @Override
    public MenuItemResponseDTO createMenuItem(MenuItemRequestDTO menuItemRequestDTO) {
        MenuItem menuItem = new MenuItem();
        menuItem.setItemName(menuItemRequestDTO.getItemName());
        menuItem.setDescription(menuItemRequestDTO.getDescription());
        menuItem.setPrice(menuItemRequestDTO.getPrice());
        menuItem.setCategory(menuItemRequestDTO.getCategory());
        MenuItem savedMenuItem = menuItemRepository.save(menuItem);
        return convertToResponseDTO(savedMenuItem);
    }

    @Override
    public MenuItemResponseDTO updateMenuItem(Long itemId, MenuItemRequestDTO menuItemRequestDTO) {
        MenuItem menuItem = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Menu item not found with id: " + itemId));

        menuItem.setItemName(menuItemRequestDTO.getItemName());
        menuItem.setDescription(menuItemRequestDTO.getDescription());
        menuItem.setPrice(menuItemRequestDTO.getPrice());
        menuItem.setCategory(menuItemRequestDTO.getCategory());

        MenuItem updatedMenuItem = menuItemRepository.save(menuItem);
        return convertToResponseDTO(updatedMenuItem);
    }

    @Override
    public void deleteMenuItem(Long itemId) {
        menuItemRepository.deleteById(itemId);
    }

    private MenuItemResponseDTO convertToResponseDTO(MenuItem menuItem) {
        MenuItemResponseDTO responseDTO = new MenuItemResponseDTO();
        responseDTO.setItemId(menuItem.getItemId());
        responseDTO.setItemName(menuItem.getItemName());
        responseDTO.setDescription(menuItem.getDescription());
        responseDTO.setPrice(menuItem.getPrice());
        responseDTO.setCategory(menuItem.getCategory());
        return responseDTO;
    }
}
