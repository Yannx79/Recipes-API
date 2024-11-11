package com.nk.recipesapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean("categoryModelMapper")
    public ModelMapper categoryModelMapper(){
        return new ModelMapper();
    }

    @Bean("ingredientModelMapper")
    public ModelMapper ingredientModelMapper(){
        return new ModelMapper();
    }

    @Bean("measurementUnitModelMapper")
    public ModelMapper measurementUnitModelMapper(){
        return new ModelMapper();
    }

    @Bean("productModelMapper")
    public ModelMapper productModelMapper(){
        return new ModelMapper();
    }

    @Bean("recipeModelMapper")
    public ModelMapper recipeModelMapper(){
        return new ModelMapper();
    }

}
