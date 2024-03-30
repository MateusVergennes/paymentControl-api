package com.example.paymentsControll.modules.paymentcontrol.controller;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.AccountAttachmentRequestDto;
import com.example.paymentsControll.modules.paymentcontrol.dtos.responses.AccountAttachmentResponseDto;
import com.example.paymentsControll.modules.paymentcontrol.services.AccountAttachmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/account-attachment")
@Tag(name = "CRUD - Account Attachments")
public class AccountAttachmentController {

    @Autowired
    private AccountAttachmentService accountAttachmentService;

    @GetMapping
    public ResponseEntity<List<AccountAttachmentResponseDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(accountAttachmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountAttachmentResponseDto> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(accountAttachmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<List<AccountAttachmentResponseDto>> save(@RequestBody List<AccountAttachmentRequestDto> dataList){
        List<AccountAttachmentResponseDto> savedAttachments = accountAttachmentService.save(dataList);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAttachments);
    }

    @PutMapping
    public ResponseEntity<AccountAttachmentResponseDto> update(@RequestBody AccountAttachmentRequestDto data){
        return ResponseEntity.status(HttpStatus.OK).body(accountAttachmentService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        accountAttachmentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}