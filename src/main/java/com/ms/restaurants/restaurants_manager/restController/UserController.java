package com.ms.restaurants.restaurants_manager.restController;

import com.ms.restaurants.restaurants_manager.dto.requestDto.UserRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.ResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.SuccessResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.UserResponseDTO;
import com.ms.restaurants.restaurants_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseDto<?> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return new SuccessResponseDto(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseDto<?> getUserById(@PathVariable Long userId) {
        UserResponseDTO user = userService.getUserById(userId);
        return new SuccessResponseDto(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseDto<?> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);
        return new SuccessResponseDto(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseDto<?> updateUser(@PathVariable Long userId, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(userId, userRequestDTO);
        return new SuccessResponseDto(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseDto<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new SuccessResponseDto(HttpStatus.NO_CONTENT);
    }
}
