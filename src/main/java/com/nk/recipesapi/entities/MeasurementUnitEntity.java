package com.nk.recipesapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class MeasurementUnitEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 120)
    private String description;

    @Column(length = 120)
    private String abbreviation;

    private Integer active;

    @OneToOne(mappedBy = "measurementUnit", cascade = CascadeType.ALL)
    private ProductEntity product;

    @OneToOne(mappedBy = "measurementUnit", cascade = CascadeType.ALL)
    private IngredientEntity ingredient;

}
