package com.example.warehoserestdata.controller;
import com.example.warehoserestdata.entity.Category;
import com.example.warehoserestdata.payload.CategoryDto;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    public HttpEntity<?> add(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(categoryDto));
    }
    @GetMapping
    public HttpEntity<?>getAll(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.getCategoryId(id));
    }
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestBody CategoryDto categoryDto, @PathVariable Integer id ){
        return ResponseEntity.ok(categoryService.edit(categoryDto, id));
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryService.delete(id));
    }
}
