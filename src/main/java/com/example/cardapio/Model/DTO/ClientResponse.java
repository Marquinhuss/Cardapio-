package com.example.cardapio.Model.DTO;

import java.util.List;

public record ClientResponse(Long id, String email, String password, List<Long> order_Id) {
    
    public ClientResponse(ClientDTO clientDTO){
        this(clientDTO.getId(),clientDTO.getEmail(), clientDTO.getPassword(), clientDTO.getOrders());
    }

}
