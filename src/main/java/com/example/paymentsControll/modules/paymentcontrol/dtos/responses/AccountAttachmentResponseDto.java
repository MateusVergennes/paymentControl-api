package com.example.paymentsControll.modules.paymentcontrol.dtos.responses;

import com.example.paymentsControll.modules.paymentcontrol.entities.AccountAttachments;

public record AccountAttachmentResponseDto(Long id, byte[] paymentAttachment, byte[] billAccount) {

    public AccountAttachmentResponseDto(AccountAttachments entity) {
        this(entity.getId(), entity.getPaymentAttachment(), entity.getBillAccount());
    }
}
