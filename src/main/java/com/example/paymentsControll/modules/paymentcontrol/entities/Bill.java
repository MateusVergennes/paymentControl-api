package com.example.paymentsControll.modules.paymentcontrol.entities;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.BillRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long typeAccountId;
    private Long accountAttachmentId;
    private BigDecimal value;
    private LocalDate expirationDate;
    private LocalDate paymentDate;


    public Bill(BillRequestDto data){
        this.id = data.id();
        this.typeAccountId = data.typeAccountId();
        this.accountAttachmentId = data.accountAttachmentId();
        this.value = data.value();
        this.expirationDate = data.expirationDate();
        this.paymentDate = data.paymentDate();
    }

}
