package com.example.cardapio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.Model.DTO.ClientDTO;
import com.example.cardapio.Model.Entity.Client;
import com.example.cardapio.Repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    public Client createClient(Client client){
        repository.save(client);
        return client;
    }
 
}
