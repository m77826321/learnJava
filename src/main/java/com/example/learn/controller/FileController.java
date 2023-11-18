package com.example.learn.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Tag(name = "File", description = "defines endpoints for File")
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    @PostMapping("/upload")
    void upload(@RequestParam("myfile") MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\Learn\\learn\\upload\\" + file.getOriginalFilename()));
    }

    @PostMapping("/download/{fileName}")
    ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName) throws IOException {
        var bytes = Files.readAllBytes(new File("D:\\Learn\\learn\\upload\\" + fileName).toPath());
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(bytes,httpHeaders, HttpStatus.OK);
    }
}
