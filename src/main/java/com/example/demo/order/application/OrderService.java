package com.example.demo.order.application;

import com.example.demo.order.application.dto.OrderCommand;
import com.example.demo.order.application.dto.OrderInfo;
import com.example.demo.order.domain.model.Order;
import com.example.demo.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderInfo create(OrderCommand command) {
        Order order = Order.create(
                command.orderNo(), command.buyerId(), command.sellerId(),
                command.productId(), command.quantity(),
                command.grossAmount(), command.feeAmount(), command.refundAmount(),
                command.status(), command.paidAt(), command.actorId()
        );
        return OrderInfo.from(orderRepository.save(order));
    }

    public OrderInfo findById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderInfo.from(order);
    }

    public List<OrderInfo> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderInfo::from)
                .toList();
    }

    // markSettled는 정산 배치에서 호출하는 거라 별도 처리
    public OrderInfo settle(UUID orderId, UUID batchId, UUID actorId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.markSettled(batchId, actorId);
        return OrderInfo.from(orderRepository.save(order));
    }
}