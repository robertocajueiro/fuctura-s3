package com.biblioteca.fuctura.exceptions;

public class DataIntegrityViolationException  extends RuntimeException {

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
