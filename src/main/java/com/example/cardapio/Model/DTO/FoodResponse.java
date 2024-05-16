package com.example.cardapio.Model.DTO;

import com.example.cardapio.Model.Entity.Food;

public record FoodResponse(Long id, String title, String image, Double price) {
    
    public FoodResponse(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}

