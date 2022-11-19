package com.example.warehoserestdata.controller;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.payload.InputDto;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/input")
public class InputContoller {
    @Autowired
    InputService inputService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody InputDto inputDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(inputService.add(inputDto));
    }
    @GetMapping
    public HttpEntity<?>getAll(){
        return ResponseEntity.ok(inputService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(inputService.getID(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody InputDto inputDto,@PathVariable Integer id){
        return ResponseEntity.ok(inputService.edit(inputDto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok(inputService.delete(id));
    }
}
