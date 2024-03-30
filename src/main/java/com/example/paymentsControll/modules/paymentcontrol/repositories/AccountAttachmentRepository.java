package com.example.paymentsControll.modules.paymentcontrol.repositories;

import com.example.paymentsControll.modules.paymentcontrol.entities.AccountAttachments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAttachmentRepository extends JpaRepository<AccountAttachments, Long> {
}
