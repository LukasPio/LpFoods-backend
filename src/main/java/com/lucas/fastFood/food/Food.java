package com.lucas.fastFood.food;

import com.lucas.fastFood.DTO.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String image;

    public Food(FoodRequestDTO foodRequestDTO) {
        this.name = foodRequestDTO.name();
        this.image = foodRequestDTO.image();
        this.price = foodRequestDTO.price();
    }
}
