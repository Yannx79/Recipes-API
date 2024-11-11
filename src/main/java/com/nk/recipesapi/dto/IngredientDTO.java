package com.nk.recipesapi.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nk.recipesapi.entities.MeasurementUnitEntity;
import com.nk.recipesapi.entities.RecipeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private Integer id;

    @Size(min = 0, max = 120)
    private String description;

    @JsonBackReference
    private RecipeEntity recipe;

    @JsonBackReference
    private MeasurementUnitEntity measurementUnit;

}
