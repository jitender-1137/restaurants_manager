package com.ms.restaurants.restaurants_manager.restController;

import com.ms.restaurants.restaurants_manager.dto.requestDto.MenuItemRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.MenuItemResponseDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.ResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.SuccessResponseDto;
import com.ms.restaurants.restaurants_manager.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public ResponseDto<?> getAllMenuItems() {
        List<MenuItemResponseDTO> menuItems = menuItemService.getAllMenuItems();
        return new SuccessResponseDto(menuItems, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseDto<?> getMenuItemById(@PathVariable Long itemId) {
        MenuItemResponseDTO menuItem = menuItemService.getMenuItemById(itemId);
        return new SuccessResponseDto(menuItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseDto<?> createMenuItem(@RequestBody MenuItemRequestDTO menuItemRequestDTO) {
        MenuItemResponseDTO createdMenuItem = menuItemService.createMenuItem(menuItemRequestDTO);
        return new SuccessResponseDto(createdMenuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{itemId}")
    public ResponseDto<?> updateMenuItem(@PathVariable Long itemId, @RequestBody MenuItemRequestDTO menuItemRequestDTO) {
        MenuItemResponseDTO updatedMenuItem = menuItemService.updateMenuItem(itemId, menuItemRequestDTO);
        return new SuccessResponseDto(updatedMenuItem, HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseDto<?> deleteMenuItem(@PathVariable Long itemId) {
        menuItemService.deleteMenuItem(itemId);
        return new SuccessResponseDto(HttpStatus.NO_CONTENT);
    }
}
