package com.lucas.fastFood.DTO;

import com.lucas.fastFood.food.Food;

public record FoodRequestDTO(String name, String image, Double price) {
}
