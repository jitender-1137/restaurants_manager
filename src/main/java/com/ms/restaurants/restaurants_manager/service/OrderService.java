package com.ms.restaurants.restaurants_manager.service;

import com.ms.restaurants.restaurants_manager.dto.requestDto.OrderRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    List<OrderResponseDTO> getAllOrders();

    OrderResponseDTO getOrderById(Long orderId);

    OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO updateOrder(Long orderId, OrderRequestDTO orderRequestDTO);

    void deleteOrder(Long orderId);
}
