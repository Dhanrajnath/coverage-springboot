package com.springproject.multiplexinfoapp.exception.multiplex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MultiplexExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<MultiplexErrorResponse> handleException(MultiplexNotFoundException exc)
    {
        MultiplexErrorResponse error = new MultiplexErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MultiplexErrorResponse> handleException(Exception exc)
    {
        MultiplexErrorResponse error = new MultiplexErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
