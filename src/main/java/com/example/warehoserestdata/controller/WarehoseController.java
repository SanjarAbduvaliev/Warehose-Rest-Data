package com.example.warehoserestdata.controller;

import com.example.warehoserestdata.entity.Warehouse;
import com.example.warehoserestdata.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/warehouse")
public class WarehoseController {
    @Autowired
    WarehouseService warehouseService;
    @PostMapping
    public HttpEntity<?> add(@RequestBody Warehouse warehouseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.add(warehouseDto));
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(warehouseService.geAll());
    }
    @GetMapping("/{id}")
    private HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(warehouseService.getId(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody Warehouse warehouseDto, @PathVariable Integer id){
        return ResponseEntity.ok(warehouseService.editWarehose(warehouseDto, id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(warehouseService.deleteWarehose(id));
    }
}
