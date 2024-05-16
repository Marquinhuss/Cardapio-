package com.example.cardapio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.Model.Entity.Client;
import com.example.cardapio.Service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService service;

    @PostMapping
    public Client createClient(@RequestBody Client client){
        service.createClient(client);
        return client;
    }
}
