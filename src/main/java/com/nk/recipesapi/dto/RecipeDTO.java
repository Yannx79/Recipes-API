package com.nk.recipesapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nk.recipesapi.entities.IngredientEntity;
import com.nk.recipesapi.entities.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDTO {

    private Integer id;

    @Size(min = 0, max = 120)
    private String description;

    @JsonBackReference
    private ProductEntity product;

    @JsonManagedReference
    private List<IngredientEntity> ingredients;


}
