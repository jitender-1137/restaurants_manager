package com.ms.restaurants.restaurants_manager.service;

import com.ms.restaurants.restaurants_manager.dto.requestDto.MenuItemRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.MenuItemResponseDTO;

import java.util.List;

public interface MenuItemService {

    List<MenuItemResponseDTO> getAllMenuItems();

    MenuItemResponseDTO getMenuItemById(Long itemId);

    MenuItemResponseDTO createMenuItem(MenuItemRequestDTO menuItemRequestDTO);

    MenuItemResponseDTO updateMenuItem(Long itemId, MenuItemRequestDTO menuItemRequestDTO);

    void deleteMenuItem(Long itemId);
}
