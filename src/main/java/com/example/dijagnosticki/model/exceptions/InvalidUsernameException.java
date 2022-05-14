package com.example.dijagnosticki.model.exceptions;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException() {
        super("Invalid ID");
    }
}
