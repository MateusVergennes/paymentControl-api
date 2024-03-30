package com.example.paymentsControll.modules.paymentcontrol.services;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.BillRequestDto;
import com.example.paymentsControll.modules.paymentcontrol.dtos.responses.BillResponseDto;
import com.example.paymentsControll.modules.paymentcontrol.entities.Bill;
import com.example.paymentsControll.modules.paymentcontrol.repositories.BillRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Transactional
    public List<BillResponseDto> findAll(){
        return billRepository.findAll().stream().map(BillResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public BillResponseDto findById(Long id){
        var entity = billRepository.findById(id);
        return entity.map(BillResponseDto::new).orElse(null);
    }

    public List<BillResponseDto> save(List<BillRequestDto> dataList){
        List<Bill> savedBill = dataList.stream()
                .map(Bill::new)
                .map(billRepository::save)
                .toList();

        return savedBill.stream()
                .map(BillResponseDto::new)
                .collect(Collectors.toList());
    }

    public BillResponseDto update(BillRequestDto dto){
        var entity = billRepository.findById(dto.id()).orElse(null);
        Bill saved;

        if(entity!=null){
            entity.setTypeAccountId(dto.typeAccountId());
            entity.setAccountAttachmentId(dto.accountAttachmentId());
            entity.setValue(dto.value());
            entity.setExpirationDate(dto.expirationDate());
            entity.setPaymentDate(dto.paymentDate());
            saved = billRepository.save(entity);
        }else {
            saved = null;
        }

        return Stream.of(saved).filter(Objects::nonNull).map(BillResponseDto::new).toList().get(0);
    }

    public void deleteById(Long id){
        billRepository.deleteById(id);
    }


}
