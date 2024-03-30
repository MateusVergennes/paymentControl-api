package com.example.paymentsControll.modules.paymentcontrol.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillRequestDto(Long id, Long typeAccountId, Long accountAttachmentId, BigDecimal value, LocalDate expirationDate, LocalDate paymentDate) {
}
