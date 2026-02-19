package com.maxim.controller;

import com.maxim.exceptions.FileUploadException;
import com.maxim.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    // загрузка файла
    @PostMapping
    public ResponseEntity<HttpStatus> upload(@RequestParam("file_key") MultipartFile file) throws FileUploadException {
        fileService.upload(file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
