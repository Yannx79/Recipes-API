package com.nk.recipesapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nk.recipesapi.entities.CategoryEnum;
import com.nk.recipesapi.entities.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private Integer id;

    private CategoryEnum category;

    @Size(min = 0, max = 120)
    private String description;

    @Min(value = 0)
    @Max(value = 1)
    private Integer active;

    @JsonManagedReference
    private ProductEntity product;

}
