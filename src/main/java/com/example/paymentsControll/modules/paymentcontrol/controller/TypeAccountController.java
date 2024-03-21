package com.example.paymentsControll.modules.paymentcontrol.controller;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.TypeAccountRequestDto;
import com.example.paymentsControll.modules.paymentcontrol.dtos.responses.TypeAccountResponseDto;
import com.example.paymentsControll.modules.paymentcontrol.services.TypeAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/type-account")
@Tag(name = "CRUD - TypeAccount")
public class TypeAccountController {

    @Autowired
    private TypeAccountService typeAccountService;

    @GetMapping
    public ResponseEntity<List<TypeAccountResponseDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(typeAccountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeAccountResponseDto> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(typeAccountService.findById(id));
    }

    @PostMapping
    public ResponseEntity<List<TypeAccountResponseDto>> save(@RequestBody List<TypeAccountRequestDto> dataList){
        List<TypeAccountResponseDto> savedTypeAccountDtos = typeAccountService.save(dataList);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTypeAccountDtos);
    }

    @PutMapping
    public ResponseEntity<TypeAccountResponseDto> update (@RequestBody TypeAccountRequestDto data){
        return ResponseEntity.status(HttpStatus.OK).body(typeAccountService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        typeAccountService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
