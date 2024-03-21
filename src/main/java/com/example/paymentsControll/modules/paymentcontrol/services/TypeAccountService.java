package com.example.paymentsControll.modules.paymentcontrol.services;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.TypeAccountRequestDto;
import com.example.paymentsControll.modules.paymentcontrol.dtos.responses.TypeAccountResponseDto;
import com.example.paymentsControll.modules.paymentcontrol.entities.TypeAccount;
import com.example.paymentsControll.modules.paymentcontrol.repositories.TypeAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TypeAccountService {

    @Autowired
    private TypeAccountRepository typeAccountRepository;

    @Transactional
    public List<TypeAccountResponseDto> findAll(){
        return typeAccountRepository.findAll().stream().map(TypeAccountResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public TypeAccountResponseDto findById(Long id){
        var entity = typeAccountRepository.findById(id);
        return entity.map(TypeAccountResponseDto::new).orElse(null);
    }

    public List<TypeAccountResponseDto> save(List<TypeAccountRequestDto> dataList){
        List<TypeAccount> savedTypeAccount = dataList.stream()
                .map(TypeAccount::new)
                .map(typeAccountRepository::save)
                .toList();

        return savedTypeAccount.stream()
                .map(TypeAccountResponseDto::new)
                .collect(Collectors.toList());
    }

    public TypeAccountResponseDto update(TypeAccountRequestDto dto){
        var entity = typeAccountRepository.findById(dto.id()).orElse(null);
        TypeAccount saved;

        if (entity!=null){
            entity.setEmail(dto.email());
            saved = typeAccountRepository.save(entity);
        }else{
            saved = null;
        }

        return Stream.of(saved).filter(Objects::nonNull).map(TypeAccountResponseDto::new).toList().get(0);
    }

    public void deleteById(Long id){
        typeAccountRepository.deleteById(id);
    }
}
