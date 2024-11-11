package com.nk.recipesapi.services.Impl;

import com.nk.recipesapi.entities.RecipeEntity;
import com.nk.recipesapi.repositories.IGenericRepository;
import com.nk.recipesapi.repositories.IRecipeRepository;
import com.nk.recipesapi.services.IRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl extends CRUDImpl<RecipeEntity, Integer> implements IRecipeService {

    private final IRecipeRepository repository;

    @Override
    protected IGenericRepository<RecipeEntity, Integer> getRepo() {
        return repository;
    }
}

