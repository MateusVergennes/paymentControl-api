package com.example.paymentsControll.modules.paymentcontrol.entities;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.AccountAttachmentRequestDto;
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
public class AccountAttachments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //os campos paymentAttachment e billAccount foram adicionados como tipo byte[] e anotados com @Lob
    // para indicar que são objetos grandes (LOB - Large Objects) no banco de dados.
    // Além disso, a definição da coluna foi especificada como bytea, que é o tipo de dados adequado
    // para armazenar dados binários em um banco de dados PostgreSQL
    @Lob
    @Column(name = "payment_attachment", columnDefinition = "bytea")
    private byte[] paymentAttachment;

    @Lob
    @Column(name = "bill_account", columnDefinition = "bytea")
    private byte[] billAccount;


    public AccountAttachments(AccountAttachmentRequestDto data){
        this.id = data.id();
        this.paymentAttachment = data.paymentAttachment();
        this.billAccount = data.billAccount();
    }
}
