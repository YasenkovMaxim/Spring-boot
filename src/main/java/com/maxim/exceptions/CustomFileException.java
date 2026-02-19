package com.maxim.exceptions;

public class CustomFileException extends Exception{
    public CustomFileException(String message) {
        super("file exception" + message);
    }
}
