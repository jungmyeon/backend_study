package com.example.demo.settlement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Table(name = "\"seller_settlement\"", schema = "public")
@Comment("판매자별 정산")
public class SellerSettlement {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "settlement_batch_id", nullable = false)
    private SettlementBatch batch;      // ← settlementBatch

    @Column(name = "seller_id", nullable = false)
    private UUID sellerId;

    @Column(name = "order_count", nullable = false)
    private Integer orderCount;

    @Column(name = "gross_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal grossAmount;

    @Column(name = "fee_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal feeAmount;

    @Column(name = "refund_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal refundAmount;

    @Column(name = "settlement_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal settlementAmount;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private SettlementStatus status;

    protected SellerSettlement() {}

    private SellerSettlement(SettlementBatch batch, UUID sellerId,
                             Integer orderCount, BigDecimal grossAmount,
                             BigDecimal feeAmount, BigDecimal refundAmount,
                             BigDecimal settlementAmount) {
        this.id = UUID.randomUUID();
        this.batch = batch;
        this.sellerId = sellerId;
        this.orderCount = orderCount;
        this.grossAmount = grossAmount;
        this.feeAmount = feeAmount;
        this.refundAmount = refundAmount;
        this.settlementAmount = settlementAmount;
        this.status = SettlementStatus.COMPLETED;
    }

    public static SellerSettlement create(SettlementBatch batch, UUID sellerId,
                                          Integer orderCount, BigDecimal grossAmount,
                                          BigDecimal feeAmount, BigDecimal refundAmount,
                                          BigDecimal settlementAmount) {
        return new SellerSettlement(batch, sellerId, orderCount,
                grossAmount, feeAmount, refundAmount, settlementAmount);
    }

    @PrePersist
    public void onCreate() {
        if (id == null) id = UUID.randomUUID();
        if (status == null) status = SettlementStatus.COMPLETED;
    }
}
