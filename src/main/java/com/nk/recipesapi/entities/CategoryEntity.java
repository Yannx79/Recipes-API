package com.nk.recipesapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CategoryEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(length = 120)
    private String description;

    private Integer active;

    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    private ProductEntity product;

}
