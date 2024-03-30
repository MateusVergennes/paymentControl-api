package com.example.paymentsControll.modules.paymentcontrol.services;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.AccountAttachmentRequestDto;
import com.example.paymentsControll.modules.paymentcontrol.dtos.responses.AccountAttachmentResponseDto;
import com.example.paymentsControll.modules.paymentcontrol.entities.AccountAttachments;
import com.example.paymentsControll.modules.paymentcontrol.repositories.AccountAttachmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AccountAttachmentService {

    @Autowired
    private AccountAttachmentRepository accountAttachmentRepository;

    @Transactional
    public List<AccountAttachmentResponseDto> findAll(){
        return accountAttachmentRepository.findAll().stream().map(AccountAttachmentResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public AccountAttachmentResponseDto findById(Long id){
        var entity = accountAttachmentRepository.findById(id);
        return entity.map(AccountAttachmentResponseDto::new).orElse(null);
    }

    public List<AccountAttachmentResponseDto> save(List<AccountAttachmentRequestDto> dataList){
        List<AccountAttachments> savedAttachments = dataList.stream()
                .map(AccountAttachments::new)
                .map(accountAttachmentRepository::save)
                .toList();

        return savedAttachments.stream()
                .map(AccountAttachmentResponseDto::new)
                .collect(Collectors.toList());
    }

    public AccountAttachmentResponseDto update(AccountAttachmentRequestDto dto){
        var entity = accountAttachmentRepository.findById(dto.id()).orElse(null);
        AccountAttachments saved;

        if(entity != null){
            entity.setPaymentAttachment(dto.paymentAttachment());
            entity.setBillAccount(dto.billAccount());
            saved = accountAttachmentRepository.save(entity);
        } else {
            saved = null;
        }

        return Stream.of(saved)
                .filter(Objects::nonNull)
                .map(AccountAttachmentResponseDto::new)
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long id){
        accountAttachmentRepository.deleteById(id);
    }
}

