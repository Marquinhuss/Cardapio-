package com.example.cardapio.Handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.cardapio.Model.Error.ErrorMessage;
import com.example.cardapio.Model.Exception.FoodNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(FoodNotFoundException ex){
        ErrorMessage error = new ErrorMessage("Food Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
