package com.ms.restaurants.restaurants_manager.serviceImpl;

import com.ms.restaurants.restaurants_manager.dto.requestDto.RoleRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.RoleResponseDTO;
import com.ms.restaurants.restaurants_manager.entity.Role;
import com.ms.restaurants.restaurants_manager.repository.RoleRepository;
import com.ms.restaurants.restaurants_manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getRoleById(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));
        return convertToResponseDTO(role);
    }

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleName(roleRequestDTO.getRoleName());
        Role savedRole = roleRepository.save(role);
        return convertToResponseDTO(savedRole);
    }

    @Override
    public RoleResponseDTO updateRole(Long roleId, RoleRequestDTO roleRequestDTO) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        role.setRoleName(roleRequestDTO.getRoleName());

        Role updatedRole = roleRepository.save(role);
        return convertToResponseDTO(updatedRole);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    private RoleResponseDTO convertToResponseDTO(Role role) {
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.setRoleId(role.getRoleId());
        responseDTO.setRoleName(role.getRoleName());
        return responseDTO;
    }
}
