package com.example.cardapio.Model.DTO;

import java.util.List;

public record ClientRequest(String email, String password, List<Long> order_Id) {
    
}
