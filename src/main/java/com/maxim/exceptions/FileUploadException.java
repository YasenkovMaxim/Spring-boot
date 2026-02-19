package com.maxim.exceptions;

public class FileUploadException extends Exception{
    public FileUploadException(String message) {
        super("file upload exception" + message);
    }
}
