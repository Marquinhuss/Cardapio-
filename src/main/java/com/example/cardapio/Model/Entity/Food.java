package com.example.cardapio.Model.Entity;


import com.example.cardapio.Model.DTO.FoodRequest;
import com.example.cardapio.Model.DTO.FoodResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Table(name= "foods")
@Entity(name = "foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String image;

    private Double price;
  
    public Food(FoodRequest x){
        this.title = x.title();
        this.image = x.image();
        this.price = x.price();
    }

    public Food(FoodResponse y){
        this.id = y.id();
        this.title = y.title();
        this.image = y.image();
        this.price = y.price();
    }

}
