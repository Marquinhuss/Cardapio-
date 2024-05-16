package com.example.cardapio.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.Model.DTO.FoodRequest;
import com.example.cardapio.Model.DTO.FoodResponse;
import com.example.cardapio.Model.Entity.Food;
import com.example.cardapio.Repository.FoodRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("food")
public class FoodController {
    
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping()
    public ResponseEntity<FoodResponse> saveFood(@RequestBody FoodRequest request){
        Food food = new Food(request);

        repository.save(food);

        FoodResponse foodResponse = new FoodResponse(food);

        return new ResponseEntity<>(foodResponse, HttpStatus.CREATED) ;
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponse>> getAll(){
        
        List<FoodResponse> foodList = repository.findAll()
                                        .stream()
                                        .map(FoodResponse::new)
                                        .collect(Collectors.toList());
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFood(@PathVariable Long id){
        
        Optional<Food> food = repository.findById(id);
        if(food.get().getId() != 0){
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<FoodResponse> updateFood(@PathVariable Long id, @RequestBody Food food) {
        Optional<Food> oldFood = repository.findById(id);
        Long oldId = oldFood.get().getId();
        food.setId(oldId);
        repository.save(food);
        FoodResponse responseDTO = new FoodResponse(food);

        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }


}
