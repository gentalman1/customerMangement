package com.psp.cm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public Object handleCustomException(HttpServletRequest req, CustomerException e) {
        HttpStatus httpStatus = e.getStatusCode();
        return ResponseEntity.status(httpStatus)
                .body(new ResponseException(e.getMessage(), httpStatus.value(), httpStatus.name(), req.getServletPath(), new Date()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errorMessages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error -> errorMessages.add(error.getDefaultMessage()));
        return ResponseEntity.status(httpStatus).body(new ResponseException(errorMessages.toString(), httpStatus.value(), httpStatus.name(), req.getServletPath(), new Date()));
    }

}
