package com.example.warehoserestdata.controller;
import com.example.warehoserestdata.payload.InputProductDto;
import com.example.warehoserestdata.service.InputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inputproduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;
    @PostMapping
    public HttpEntity<?> add(InputProductDto inputProductDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(inputProductService.add(inputProductDto));
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(inputProductService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(inputProductService.getId(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody InputProductDto inputProductDto, @PathVariable Integer id){
        return ResponseEntity.ok(inputProductService.edit(inputProductDto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok(inputProductService.delete(id));
    }
}
