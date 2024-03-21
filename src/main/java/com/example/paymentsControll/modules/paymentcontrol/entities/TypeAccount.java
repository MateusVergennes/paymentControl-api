package com.example.paymentsControll.modules.paymentcontrol.entities;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.TypeAccountRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    public TypeAccount(TypeAccountRequestDto data){
        this.id = data.id();
        this.email = data.email();
    }
}
