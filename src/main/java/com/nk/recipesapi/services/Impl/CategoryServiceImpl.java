package com.nk.recipesapi.services.Impl;

import com.nk.recipesapi.entities.CategoryEntity;
import com.nk.recipesapi.repositories.ICategoryRepository;
import com.nk.recipesapi.repositories.IGenericRepository;
import com.nk.recipesapi.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<CategoryEntity, Integer> implements ICategoryService {

    private final ICategoryRepository repository;

    @Override
    protected IGenericRepository<CategoryEntity, Integer> getRepo() {
        return repository;
    }
}
