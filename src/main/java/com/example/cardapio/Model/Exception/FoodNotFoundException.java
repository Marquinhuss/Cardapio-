package com.example.cardapio.Model.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FoodNotFoundException extends RuntimeException {
    
    public FoodNotFoundException(String message){
        super(message);
    }

}
