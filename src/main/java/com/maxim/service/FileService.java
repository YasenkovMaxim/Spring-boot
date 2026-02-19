package com.maxim.service;

import com.maxim.exceptions.CustomFileException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path ROOT_FILE_PATH = Paths.get("data"); // хранит путь куда закидывать файлы

    public void upload(MultipartFile file) throws CustomFileException {
        try {
            Files.copy(file.getInputStream(), ROOT_FILE_PATH.resolve(file.getOriginalFilename()));
            // берет что нужно скинть, куда нужно, и как назвать файл в папке

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new CustomFileException(e.getMessage());
        }
    }

    public Resource getFile(String filename) throws CustomFileException {
        Path path = ROOT_FILE_PATH.resolve(filename);
        try {
            Resource resource = new UrlResource(path.toUri());
            if (!resource.exists()) {
                throw new FileNotFoundException();
            }
            if (resource.isReadable()) {
                return resource;
            }
            throw new CustomFileException("File isn't readable");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            throw new CustomFileException(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

