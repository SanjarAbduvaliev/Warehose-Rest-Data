package com.example.warehoserestdata.controller;

import com.example.warehoserestdata.payload.OutputProductDto;
import com.example.warehoserestdata.service.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/outputproduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;
    @PostMapping
    public HttpEntity<?> add(@RequestBody OutputProductDto outputProductDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(outputProductService.add(outputProductDto));
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(outputProductService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(outputProductService.getId(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody OutputProductDto outputProductDto,@PathVariable Integer id){
        return ResponseEntity.ok(outputProductService.edit(outputProductDto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(outputProductService.delete(id));
    }
}
