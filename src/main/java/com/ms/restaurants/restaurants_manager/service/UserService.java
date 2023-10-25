package com.ms.restaurants.restaurants_manager.service;

import com.ms.restaurants.restaurants_manager.dto.requestDto.UserRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long userId);

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO);

    void deleteUser(Long userId);
}
