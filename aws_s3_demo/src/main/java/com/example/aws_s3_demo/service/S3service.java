package com.example.aws_s3_demo.service;

import com.example.aws_s3_demo.config.S3Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
public class S3service {

    @Autowired
    S3Client s3client;

    @Value("${aws.bucket.name}")
    String bucketName;

    public void uploadFile(MultipartFile file) throws IOException {
        s3client.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(file.getOriginalFilename())
                .build(),
                RequestBody.fromBytes(file.getBytes()));
    }

    public byte[] downloadFile(String key) throws IOException {
        ResponseBytes<GetObjectResponse> objectAsBytes=s3client.getObjectAsBytes(GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build());
        return objectAsBytes.asByteArray();
    }

}
