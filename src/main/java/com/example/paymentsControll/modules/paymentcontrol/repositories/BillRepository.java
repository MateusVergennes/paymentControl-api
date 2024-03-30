package com.example.paymentsControll.modules.paymentcontrol.repositories;

import com.example.paymentsControll.modules.paymentcontrol.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
