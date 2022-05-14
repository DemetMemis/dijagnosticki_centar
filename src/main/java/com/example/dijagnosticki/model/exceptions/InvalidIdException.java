package com.example.dijagnosticki.model.exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super("Invalid ID");
    }
}
