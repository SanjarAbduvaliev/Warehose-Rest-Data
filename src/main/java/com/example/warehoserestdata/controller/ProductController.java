package com.example.warehoserestdata.controller;

import com.example.warehoserestdata.payload.Productdto;
import com.example.warehoserestdata.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody Productdto productdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productdto));
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getId(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody Productdto productdto, @PathVariable Integer id){
        return ResponseEntity.ok(productService.edit(productdto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.delete(id));
    }
}
