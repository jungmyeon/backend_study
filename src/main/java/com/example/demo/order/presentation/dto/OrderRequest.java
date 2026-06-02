package com.example.demo.order.presentation.dto;

import com.example.demo.order.application.dto.OrderCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderRequest(
        String orderNo,
        UUID buyerId,
        UUID sellerId,
        UUID productId,
        Integer quantity,
        BigDecimal grossAmount,
        BigDecimal feeAmount,
        BigDecimal refundAmount,
        String status,
        LocalDateTime paidAt,
        UUID actorId
) {
    public OrderCommand toCommand() {
        return new OrderCommand(
                orderNo, buyerId, sellerId, productId, quantity,
                grossAmount, feeAmount, refundAmount, status, paidAt, actorId
        );
    }
}
