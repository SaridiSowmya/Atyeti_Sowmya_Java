package com.example.orderprocessingsystem.exception;

public class InavalidOrderException extends RuntimeException {
    public InavalidOrderException(String message) {
        super(message);
    }
}
