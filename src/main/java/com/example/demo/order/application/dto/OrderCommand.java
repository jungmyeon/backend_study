package com.example.demo.order.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

// create() 팩토리 파라미터 그대로
public record OrderCommand(
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
) {}
