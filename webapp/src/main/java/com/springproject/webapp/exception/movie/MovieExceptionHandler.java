package com.springproject.webapp.exception.movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(MovieNotFoundException exc)
    {
        MovieErrorResponse error = new MovieErrorResponse();

        error.setMessage1("We will be available soon ");
        error.setMessage2(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(Exception exc)
    {
        MovieErrorResponse error = new MovieErrorResponse();

        error.setMessage1("We will be available soon ");
        error.setMessage2(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
