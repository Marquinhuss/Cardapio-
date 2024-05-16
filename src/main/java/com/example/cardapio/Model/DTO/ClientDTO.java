package com.example.cardapio.Model.DTO;

import java.util.List;

import com.example.cardapio.Model.Entity.Client;

import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class ClientDTO {
    private Long id;

    private String email;

    private String password;

    private List<Long> orders;

    public ClientDTO(Client client){
        this.id = client.getId();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.orders = client.getOrders_Id();
    }
}
