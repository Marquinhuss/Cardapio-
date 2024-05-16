package com.example.cardapio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardapio.Model.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{
    
}
