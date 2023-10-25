package com.ms.restaurants.restaurants_manager.restController;

import com.ms.restaurants.restaurants_manager.dto.requestDto.MenuRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.MenuResponseDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.ResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.SuccessResponseDto;
import com.ms.restaurants.restaurants_manager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseDto<?> getAllMenus() {
        List<MenuResponseDTO> menus = menuService.getAllMenus();
        return new SuccessResponseDto(menus, HttpStatus.OK);
    }

    @GetMapping("/{menuId}")
    public ResponseDto<?> getMenuById(@PathVariable Long menuId) {
        MenuResponseDTO menu = menuService.getMenuById(menuId);
        return new SuccessResponseDto(menu, HttpStatus.OK);
    }

    @PostMapping
    public ResponseDto<?> createMenu(@RequestBody MenuRequestDTO menuRequestDTO) {
        MenuResponseDTO createdMenu = menuService.createMenu(menuRequestDTO);
        return new SuccessResponseDto(createdMenu, HttpStatus.CREATED);
    }

    @PutMapping("/{menuId}")
    public ResponseDto<?> updateMenu(@PathVariable Long menuId, @RequestBody MenuRequestDTO menuRequestDTO) {
        MenuResponseDTO updatedMenu = menuService.updateMenu(menuId, menuRequestDTO);
        return new SuccessResponseDto(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/{menuId}")
    public ResponseDto<?> deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
        return new SuccessResponseDto(HttpStatus.NO_CONTENT);
    }
}
