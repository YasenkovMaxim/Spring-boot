package com.maxim.exceptions;

public class SecurityNotFound extends RuntimeException {
    public SecurityNotFound() {
        super("Security not found");
    }
}
