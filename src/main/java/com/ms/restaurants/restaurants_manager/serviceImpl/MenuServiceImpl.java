package com.ms.restaurants.restaurants_manager.serviceImpl;

import com.ms.restaurants.restaurants_manager.dto.requestDto.MenuRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.MenuResponseDTO;
import com.ms.restaurants.restaurants_manager.entity.Menu;
import com.ms.restaurants.restaurants_manager.repository.MenuRepository;
import com.ms.restaurants.restaurants_manager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuResponseDTO> getAllMenus() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MenuResponseDTO getMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuId));
        return convertToResponseDTO(menu);
    }

    @Override
    public MenuResponseDTO createMenu(MenuRequestDTO menuRequestDTO) {
        Menu menu = new Menu();
        menu.setMenuName(menuRequestDTO.getMenuName());
        menu.setDescription(menuRequestDTO.getDescription());
        Menu savedMenu = menuRepository.save(menu);
        return convertToResponseDTO(savedMenu);
    }

    @Override
    public MenuResponseDTO updateMenu(Long menuId, MenuRequestDTO menuRequestDTO) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuId));

        menu.setMenuName(menuRequestDTO.getMenuName());
        menu.setDescription(menuRequestDTO.getDescription());

        Menu updatedMenu = menuRepository.save(menu);
        return convertToResponseDTO(updatedMenu);
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    private MenuResponseDTO convertToResponseDTO(Menu menu) {
        MenuResponseDTO responseDTO = new MenuResponseDTO();
        responseDTO.setMenuId(menu.getMenuId());
        responseDTO.setMenuName(menu.getMenuName());
        responseDTO.setDescription(menu.getDescription());
        return responseDTO;
    }
}
