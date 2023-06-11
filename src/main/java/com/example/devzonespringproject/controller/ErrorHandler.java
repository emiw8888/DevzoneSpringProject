package com.example.devzonespringproject.controller;

import com.example.devzonespringproject.model.exception.BookNotFoundException;
import com.example.devzonespringproject.model.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(BookNotFoundException e) {
        return new ExceptionResponse(e.getMessage());
    }

}
