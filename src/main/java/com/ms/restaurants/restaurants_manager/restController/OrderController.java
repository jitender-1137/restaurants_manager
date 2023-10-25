package com.ms.restaurants.restaurants_manager.restController;

import com.ms.restaurants.restaurants_manager.dto.requestDto.OrderRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.OrderResponseDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.ResponseDto;
import com.ms.restaurants.restaurants_manager.dto.responseDto.SuccessResponseDto;
import com.ms.restaurants.restaurants_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseDto<?> getAllOrders() {
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        return new SuccessResponseDto(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseDto<?> getOrderById(@PathVariable Long orderId) {
        OrderResponseDTO order = orderService.getOrderById(orderId);
        return new SuccessResponseDto(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseDto<?> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO placedOrder = orderService.placeOrder(orderRequestDTO);
        return new SuccessResponseDto(placedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseDto<?> updateOrder(@PathVariable Long orderId, @RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO updatedOrder = orderService.updateOrder(orderId, orderRequestDTO);
        return new SuccessResponseDto(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseDto<?> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new SuccessResponseDto(HttpStatus.NO_CONTENT);
    }
}
