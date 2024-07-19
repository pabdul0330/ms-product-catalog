package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.exception.ExceptionResponse;
import com.example.msproductcatalog.model.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(NotFoundException e) {
        return new ExceptionResponse(e.getMessage());
    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public List<ExceptionResponse> handle(MethodArgumentNotValidException e) {
//        var exceptions = e.getBindingResult().getFieldErrors();
//        List<ExceptionResponse> list = new ArrayList<>();
//        for (var t : exceptions) {
//            list.add(new ExceptionResponse(t.getDefaultMessage()));
//        }
//        return list;
//    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    ExceptionResponse handler(Exception exception) {
//        return new ExceptionResponse("UNEXPECTED_EXCEPTION " + exception.getMessage());
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<ExceptionResponse> errors = new ArrayList<>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e -> errors.add(new ExceptionResponse(e.getDefaultMessage())));
        return ResponseEntity.status(status).body(errors);
    }
}
