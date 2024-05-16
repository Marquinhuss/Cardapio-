package com.example.cardapio.Model.DTO;

import java.util.List;

public record OrderRequest(Long id, Long client_Id, List<Long> foods_Id, Double totalValue) {
    
}
