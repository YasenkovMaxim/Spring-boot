package com.maxim.service;

import com.maxim.exceptions.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path ROOT_FILE_PATH = Paths.get("data"); // хранит путь куда закидывать файлы

    public void upload(MultipartFile file) throws FileUploadException {
        try {
            Files.copy(file.getInputStream(), ROOT_FILE_PATH.resolve(file.getOriginalFilename()));
            // берет что нужно скинть, куда нужно, и как назвать файл в папке

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new FileUploadException(e.getMessage());
        }
    }
}
