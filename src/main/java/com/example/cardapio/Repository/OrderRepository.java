package com.example.cardapio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cardapio.Model.Entity.Orders;


public interface OrderRepository extends JpaRepository<Orders, Long>{
    
}
