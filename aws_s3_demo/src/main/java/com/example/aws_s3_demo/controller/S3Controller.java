package com.example.aws_s3_demo.controller;

import com.example.aws_s3_demo.service.S3service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/v1")
@RestController
public class S3Controller {

    @Autowired
    S3service s3service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        s3service.uploadFile(file);
        return ResponseEntity.ok("File uploaded Successfully !");
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename) throws IOException {
        s3service.downloadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .body(s3service.downloadFile(filename));
    }


}
