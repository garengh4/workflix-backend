package com.infy.workflixbackend42.utility;

import com.infy.workflixbackend42.exception.WorkflixException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

    @Autowired
    Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo error = new ErrorInfo();
        error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE")+exception.getMessage());
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WorkflixException.class)
    public ResponseEntity<ErrorInfo> workflixExceptionHandler(WorkflixException exception) {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo error = new ErrorInfo();
        error.setErrorMessage(environment.getProperty(exception.getMessage()));
        error.setTimestamp(LocalDateTime.now());
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        String errorMsg = "";
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception1 = (MethodArgumentNotValidException) exception;
            errorMsg = exception1.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(", "));
        } else {
            ConstraintViolationException exception1 = (ConstraintViolationException) exception;
            errorMsg = exception1.getConstraintViolations().stream().map(x -> x.getMessage())
                    .collect(Collectors.joining(", "));
        }
        errorInfo.setErrorMessage(errorMsg);
        errorInfo.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }


}