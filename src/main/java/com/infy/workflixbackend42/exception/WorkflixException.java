package com.infy.workflixbackend42.exception;


public class WorkflixException extends Exception {
    private static final long serialVersionUID = 1L;

    public WorkflixException(String message) {
        super(message);
    }
}