package com.nk.recipesapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nk.recipesapi.entities.CategoryEntity;
import com.nk.recipesapi.entities.MeasurementUnitEntity;
import com.nk.recipesapi.entities.RecipeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;

    @Size(min = 0, max = 120)
    private String name;

    @Size(min = 0, max = 120)
    private String description;

    private LocalDate enterDate;

    @JsonBackReference
    private CategoryEntity category;

    @JsonBackReference
    private MeasurementUnitEntity measurementUnit;

    @JsonManagedReference
    private RecipeEntity recipe;


}
