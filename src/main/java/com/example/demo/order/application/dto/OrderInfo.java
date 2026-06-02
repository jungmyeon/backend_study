package com.example.demo.order.application.dto;

import com.example.demo.order.domain.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderInfo(
        UUID id,
        String orderNo,
        UUID buyerId,
        UUID sellerId,
        UUID productId,
        Integer quantity,
        BigDecimal grossAmount,
        BigDecimal feeAmount,
        BigDecimal refundAmount,
        BigDecimal netAmount,
        String status,
        LocalDateTime paidAt,
        Boolean settled,
        UUID settlementBatchId,
        LocalDateTime regDt,
        LocalDateTime modifyDt
) {
    public static OrderInfo from(Order order) {
        return new OrderInfo(
                order.getId(), order.getOrderNo(),
                order.getBuyerId(), order.getSellerId(), order.getProductId(),
                order.getQuantity(),
                order.getGrossAmount(), order.getFeeAmount(),
                order.getRefundAmount(), order.getNetAmount(),
                order.getStatus(), order.getPaidAt(),
                order.getSettled(), order.getSettlementBatchId(),
                order.getRegDt(), order.getModifyDt()
        );
    }
}