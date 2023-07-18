package com.dukan.controller;

import com.dukan.model.exception.ExceptionDto;
import com.dukan.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDto handle(NotFoundException exception){
        log.error("ActionLog.handle.error NotFoundException handled");
        return new ExceptionDto(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    List<ExceptionDto> handle(MethodArgumentNotValidException exception){
        log.error("ActionLog.handle.error Exception handled: {}", exception.getMessage());
        List<ExceptionDto> errors=new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e-> errors.add(new ExceptionDto(e.getDefaultMessage())));
        return errors;
    }
}

