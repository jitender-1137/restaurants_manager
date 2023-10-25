package com.ms.restaurants.restaurants_manager.service;

import com.ms.restaurants.restaurants_manager.dto.requestDto.RoleRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO getRoleById(Long roleId);

    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);

    RoleResponseDTO updateRole(Long roleId, RoleRequestDTO roleRequestDTO);

    void deleteRole(Long roleId);
}
