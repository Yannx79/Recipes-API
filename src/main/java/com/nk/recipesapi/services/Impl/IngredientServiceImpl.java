package com.nk.recipesapi.services.Impl;

import com.nk.recipesapi.entities.IngredientEntity;
import com.nk.recipesapi.repositories.IGenericRepository;
import com.nk.recipesapi.repositories.IIngredientRepository;
import com.nk.recipesapi.services.IIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl extends CRUDImpl<IngredientEntity, Integer> implements IIngredientService {

    private final IIngredientRepository repository;

    @Override
    protected IGenericRepository<IngredientEntity, Integer> getRepo() {
        return repository;
    }
}
