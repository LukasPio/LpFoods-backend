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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        System.out.println("Get requisition received");
        return foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public List<FoodResponseDTO> getById(@PathVariable Long id) {
        System.out.println("Get requisition received");
        return foodRepository.findById(id).stream().map(FoodResponseDTO::new).toList();
    }

    @PostMapping
    public void saveFoods(@RequestBody List<FoodRequestDTO> foodDataList) {
        System.out.println("Post requisition received");
        foodDataList.forEach((foodData) -> foodRepository.save(new Food(foodData)));
    }

    @DeleteMapping("/{id}")
    public void removeFoodById(@PathVariable Long id) {
        System.out.println("Delete requisition received");
        foodRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateFoodById(@PathVariable Long id, @RequestBody FoodRequestDTO foodData) {
        System.out.println("Put requisition received");
        Food oldFood = foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Food with id: "+id+" was not found."));
        oldFood.setName(foodData.name());
        oldFood.setImage(foodData.image());
        oldFood.setPrice(foodData.price());
        foodRepository.save(oldFood);
    }

}
