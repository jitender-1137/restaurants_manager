package com.ms.restaurants.restaurants_manager.serviceImpl;

import com.ms.restaurants.restaurants_manager.dto.requestDto.OrderRequestDTO;
import com.ms.restaurants.restaurants_manager.dto.responseDto.OrderResponseDTO;
import com.ms.restaurants.restaurants_manager.entity.MenuItem;
import com.ms.restaurants.restaurants_manager.entity.Order;
import com.ms.restaurants.restaurants_manager.entity.OrderItem;
import com.ms.restaurants.restaurants_manager.entity.Table;
import com.ms.restaurants.restaurants_manager.repository.MenuItemRepository;
import com.ms.restaurants.restaurants_manager.repository.OrderRepository;
import com.ms.restaurants.restaurants_manager.repository.TableRepository;
import com.ms.restaurants.restaurants_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
        return convertToResponseDTO(order);
    }

    @Override
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        Table table = tableRepository.findById(orderRequestDTO.getTableId())
                .orElseThrow(() -> new EntityNotFoundException("Table not found with id: " + orderRequestDTO.getTableId()));

        order.setTable(table);
        order.setStatus("pending");
        order.setOrderTime(LocalDateTime.now());

        List<OrderItem> orderItems = orderRequestDTO.getItems().stream()
                .map(itemRequest -> {
                    MenuItem menuItem = menuItemRepository.findById(itemRequest.getMenuItemId())
                            .orElseThrow(() -> new EntityNotFoundException("Menu item not found with id: " + itemRequest.getMenuItemId()));

                    OrderItem orderItem = new OrderItem();
                    orderItem.setMenuItem(menuItem);
                    orderItem.setQuantity(itemRequest.getQuantity());
                    orderItem.setSubtotal(menuItem.getPrice() * itemRequest.getQuantity());
//                    orderItem.setOrder(order);

                    return orderItem;
                })
                .collect(Collectors.toList());

        order.setItems(orderItems);

        Order savedOrder = orderRepository.save(order);
        return convertToResponseDTO(savedOrder);
    }

    @Override
    public OrderResponseDTO updateOrder(Long orderId, OrderRequestDTO orderRequestDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));

        // Perform update logic based on your requirements

        Order updatedOrder = orderRepository.save(order);
        return convertToResponseDTO(updatedOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    private OrderResponseDTO convertToResponseDTO(Order order) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setOrderId(order.getOrderId());
        responseDTO.setTableId(order.getTable().getTableId());
        responseDTO.setStatus(order.getStatus());
        responseDTO.setTotalPrice(order.getItems().stream().mapToDouble(OrderItem::getSubtotal).sum());
        responseDTO.setOrderTime(order.getOrderTime());
        // You may include other fields as needed
        return responseDTO;
    }
}
