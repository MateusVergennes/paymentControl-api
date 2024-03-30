package com.example.paymentsControll.modules.paymentcontrol.dtos.requests;

public record AccountAttachmentRequestDto(Long id, byte[] paymentAttachment, byte[] billAccount) {
}
