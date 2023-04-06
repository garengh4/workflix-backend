package com.infy.workflixbackend42.exception;

public class FileWriteException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public FileWriteException(String message) {
        super(message);

    }
}