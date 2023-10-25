package com.ms.restaurants.restaurants_manager.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponseDto<T> implements ResponseDto<T> {

    private int status;
    private String message = null;
    private T data;
    private LocalDateTime timestamp;

    public SuccessResponseDto(T data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
        this.message = "Success";
        this.timestamp = LocalDateTime.now();
    }

    public SuccessResponseDto(T data) {
        this.data = data;
        this.status = HttpStatus.OK.value();
        this.message = "Success";
        this.timestamp = LocalDateTime.now();
    }

    public SuccessResponseDto(String message) {
        this.message = message;
        this.status = HttpStatus.OK.value();
        this.timestamp = LocalDateTime.now();

    }

    public SuccessResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.OK.value();
    }

    public SuccessResponseDto(T data, String message, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
    }

}
