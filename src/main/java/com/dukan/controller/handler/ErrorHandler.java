package com.dukan.controller.handler;

import com.dukan.model.exception.ExceptionDTO;
import com.dukan.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;


@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDTO handle(NotFoundException e){
        log.error("ActionLog.handle.error NotFoundException handled");
        return new ExceptionDTO(e.getMessage());
    }


    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDTO handle(SQLException e){
        log.error("ActionLog.handle.error SqlException handled");
        return new ExceptionDTO(e.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    ExceptionDTO handle(Exception exception){
//        log.error("ActionLog.handle.error Exception handled");
//        return new ExceptionDTO("UNEXPECTED_ERROR");
//    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    ExceptionDTO handle(UsernameNotFoundException e){
//        log.error("ActionLog.handle.error UserNameNotFoundException handled");
//        return new ExceptionDto(e.getMessage());
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public List<ExceptionDto> handle(MethodArgumentNotValidException e){
//        List<ExceptionDto> errors = new ArrayList<>();
//        e.getBindingResult().getFieldErrors().forEach(fieldError -> errors.add(
//                new ExceptionDto(fieldError.getDefaultMessage())));
//        return errors;
//    }



}
