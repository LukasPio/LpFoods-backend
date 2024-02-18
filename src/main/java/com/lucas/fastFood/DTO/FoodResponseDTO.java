package com.lucas.fastFood.DTO;

import com.lucas.fastFood.food.Food;

public record FoodResponseDTO(Long id, String name, Double price, String image) {
        public FoodResponseDTO(Food food) {
            this(food.getId(), food.getName(), food.getPrice(), food.getImage());
        }
}
