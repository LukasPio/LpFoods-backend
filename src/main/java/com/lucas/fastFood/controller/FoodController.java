package com.lucas.fastFood.controller;

import com.lucas.fastFood.food.Food;
import com.lucas.fastFood.DTO.FoodRequestDTO;
import com.lucas.fastFood.DTO.FoodResponseDTO;
import com.lucas.fastFood.food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foods")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO foodData) {
        foodRepository.save(new Food(foodData));
    }

}
