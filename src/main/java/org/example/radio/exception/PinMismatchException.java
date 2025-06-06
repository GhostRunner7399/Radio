package org.example.radio.exception;

public class PinMismatchException extends RuntimeException {
    public PinMismatchException(String message) {
        super(message);
    }
}
