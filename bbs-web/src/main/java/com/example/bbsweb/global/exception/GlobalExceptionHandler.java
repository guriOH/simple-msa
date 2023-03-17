package com.example.bbsweb.global.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String custom(){
        return "Test";
    }
}
