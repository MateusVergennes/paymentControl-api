package com.example.paymentsControll.modules.paymentcontrol.dtos.responses;

import com.example.paymentsControll.modules.paymentcontrol.entities.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillResponseDto(Long id, Long typeAccountId, Long accountAttachmentId, BigDecimal value, LocalDate expirationDate, LocalDate paymentDate) {

    public BillResponseDto(Bill entity) {
        this(entity.getId(), entity.getTypeAccountId(), entity.getAccountAttachmentId(), entity.getValue(), entity.getExpirationDate(), entity.getPaymentDate());
    }

}
