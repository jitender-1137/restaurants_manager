package com.ms.restaurants.restaurants_manager.restController;

import com.ms.restaurants.restaurants_manager.dto.requestDto.RoleRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.ResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.RoleResponseDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.SuccessResponseDto;
import com.ms.restaurants.restaurants_manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseDto<?> getAllRoles() {
        List<RoleResponseDTO> roles = roleService.getAllRoles();
        return new SuccessResponseDto(roles, HttpStatus.OK);
    }

    @GetMapping("/{roleId}")
    public ResponseDto<?> getRoleById(@PathVariable Long roleId) {
        RoleResponseDTO role = roleService.getRoleById(roleId);
        return new SuccessResponseDto(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseDto<?> createRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO createdRole = roleService.createRole(roleRequestDTO);
        return new SuccessResponseDto(createdRole, HttpStatus.CREATED);
    }

    @PutMapping("/{roleId}")
    public ResponseDto<?> updateRole(@PathVariable Long roleId, @RequestBody RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO updatedRole = roleService.updateRole(roleId, roleRequestDTO);
        return new SuccessResponseDto(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseDto<?> deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return new SuccessResponseDto(HttpStatus.NO_CONTENT);
    }
}
