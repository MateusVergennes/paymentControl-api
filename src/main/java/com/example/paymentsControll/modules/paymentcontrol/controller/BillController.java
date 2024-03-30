package com.example.paymentsControll.modules.paymentcontrol.controller;

import com.example.paymentsControll.modules.paymentcontrol.dtos.requests.BillRequestDto;
import com.example.paymentsControll.modules.paymentcontrol.dtos.responses.BillResponseDto;
import com.example.paymentsControll.modules.paymentcontrol.services.BillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/bill")
@Tag(name = "CRUD - Bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public ResponseEntity<List<BillResponseDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(billService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillResponseDto> findById(@PathVariable(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(billService.findById(id));
    }

    @PostMapping
    public ResponseEntity<List<BillResponseDto>> save(@RequestBody List<BillRequestDto> dataList){
        List<BillResponseDto> savedBillDtos = billService.save(dataList);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBillDtos);
    }

    @PutMapping
    public ResponseEntity<BillResponseDto> update(@RequestBody BillRequestDto data){
        return ResponseEntity.status(HttpStatus.OK).body(billService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id")Long id){
        billService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
