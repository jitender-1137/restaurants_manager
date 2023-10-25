package com.ms.restaurants.restaurants_manager.service;

import com.ms.restaurants.restaurants_manager.dto.requestDto.MenuRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.MenuResponseDTO;

import java.util.List;

public interface MenuService {

    List<MenuResponseDTO> getAllMenus();

    MenuResponseDTO getMenuById(Long menuId);

    MenuResponseDTO createMenu(MenuRequestDTO menuRequestDTO);

    MenuResponseDTO updateMenu(Long menuId, MenuRequestDTO menuRequestDTO);

    void deleteMenu(Long menuId);
}
