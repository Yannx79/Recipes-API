package com.nk.recipesapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ProductEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String name;

    @Column(length = 120)
    private String description;

    private LocalDate enterDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnitEntity measurementUnit;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private RecipeEntity recipe;

}
