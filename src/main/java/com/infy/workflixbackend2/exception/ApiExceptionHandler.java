package com.infy.workflixbackend2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(FileWriteException.class)
    public ApiException handleFileWriteException(FileWriteException e){
        ApiException exception=new ApiException();
        exception.setErrorMessage(e.getMessage());
        exception.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return exception;
    }
}
