package com.nk.recipesapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nk.recipesapi.entities.IngredientEntity;
import com.nk.recipesapi.entities.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementUnitDTO {

    private Integer id;

    @Size(min = 0, max = 120)
    private String description;

    @Size(min = 0, max = 120)
    private String abbreviation;

    @Min(value = 0)
    @Max(value = 1)
    private Integer active;

    @JsonManagedReference
    private ProductEntity product;

    @JsonManagedReference
    private IngredientEntity ingredient;


}
