package com.example.warehoserestdata.controller;

//import com.example.appwarehouse.entity.Attachment;
//import com.example.appwarehouse.payload.Result;
//import com.example.appwarehouse.service.AttachmentService;
import com.example.warehoserestdata.entity.Attachment;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @PostMapping
    public HttpEntity<?> upload(MultipartHttpServletRequest request) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(attachmentService.uploadFile(request));

    }
    @GetMapping
    public HttpEntity<?> geAll(){
        return ResponseEntity.ok(attachmentService.getAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Integer id){
        return ResponseEntity.ok(attachmentService.getId(id));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(MultipartHttpServletRequest request, @PathVariable Integer id) throws IOException {
        return ResponseEntity.ok(attachmentService.editPhoto(request,id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(attachmentService.deletePhoto(id));
    }
}
