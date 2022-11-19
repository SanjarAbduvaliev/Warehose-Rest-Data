package com.example.warehoserestdata.controller;

import com.example.warehoserestdata.payload.SaleDto;
import com.example.warehoserestdata.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    SaleService service;

    @PostMapping
    public HttpEntity<?> add(@RequestBody SaleDto saleDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addSale(saleDto));
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(service.getId(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody SaleDto saleDto,@PathVariable Integer id){
        return ResponseEntity.ok(service.edit(saleDto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
    }
}
