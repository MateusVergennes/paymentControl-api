package com.example.paymentsControll.modules.paymentcontrol.dtos.responses;

import com.example.paymentsControll.modules.paymentcontrol.entities.TypeAccount;

public record TypeAccountResponseDto(Long id, String email) {

    public TypeAccountResponseDto(TypeAccount entity){
        this(entity.getId(), entity.getEmail());
    }
}
