package com.example.warehoserestdata.controller;
import com.example.warehoserestdata.entity.Currency;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @PostMapping("/addCurrency")
    public HttpEntity<?> add(@RequestBody Currency currencydto){
        Result result = currencyService.addCurrency(currencydto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping
    public HttpEntity<?> getAllCurrency(){
        return ResponseEntity.ok(currencyService.getAll());
    }
    @GetMapping("/{currencyId}")
    public HttpEntity<?> getId(@PathVariable Integer currencyId){
        return ResponseEntity.ok(currencyService.getId(currencyId));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody Currency currencyDto, @PathVariable Integer id){
        return ResponseEntity.ok(currencyService.edit(currencyDto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(currencyService.delete(id));
    }

}
