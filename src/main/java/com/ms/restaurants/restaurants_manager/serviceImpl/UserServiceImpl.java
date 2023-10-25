package com.ms.restaurants.restaurants_manager.serviceImpl;

import com.ms.restaurants.restaurants_manager.dto.requestDto.UserRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.UserResponseDTO;
import com.ms.restaurants.restaurants_manager.entity.Users;
import com.ms.restaurants.restaurants_manager.repository.UserRepository;
import com.ms.restaurants.restaurants_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        return convertToResponseDTO(user);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword()); // You should handle password encryption in a real application
        Users savedUser = userRepository.save(user);
        return convertToResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword()); // You should handle password encryption in a real application

        Users updatedUser = userRepository.save(user);
        return convertToResponseDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserResponseDTO convertToResponseDTO(Users user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setUsername(user.getUsername());
        // Omitting password for security reasons
        return responseDTO;
    }
}
