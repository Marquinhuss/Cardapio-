package com.example.cardapio.Model.DTO;

import java.util.List;

import com.example.cardapio.Model.Entity.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    
    private Long id;

    private Long client_Id;

    private List<Long> foods_Id;

    private Double totalValue;

    public OrderDTO(Orders order){
        this(order.getId(), order.getClient_Id(),order.getFoods_Id(), order.getTotalValue());
    }

    public static OrderDTO fromOrderRequest(OrderRequest orderRequest) {
        return new OrderDTO(orderRequest.id(), orderRequest.client_Id(), orderRequest.foods_Id(), orderRequest.totalValue());
    }
}
