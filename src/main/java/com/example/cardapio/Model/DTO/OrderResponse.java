package com.example.cardapio.Model.DTO;

import java.util.List;

public record OrderResponse(Long id, Long client_Id, List<Long> foods_Id, Double totalValue) {
    
    public OrderResponse(OrderDTO orderDTO){
        this(orderDTO.getId(), orderDTO.getClient_Id(), orderDTO.getFoods_Id(), orderDTO.getTotalValue());
    }

}
