package com.example.cardapio.Model.Entity;

import java.util.List;

import com.example.cardapio.Model.DTO.OrderDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "order")
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    private Long client_Id;

    private List<Long> foods_Id;

    private Double totalValue;

    public Orders(OrderDTO dto){
        this(dto.getId(), dto.getClient_Id(), dto.getFoods_Id(), dto.getTotalValue());
    }

}
