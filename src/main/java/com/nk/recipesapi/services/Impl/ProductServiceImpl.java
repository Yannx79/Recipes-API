package com.nk.recipesapi.services.Impl;

import com.nk.recipesapi.entities.ProductEntity;
import com.nk.recipesapi.repositories.IGenericRepository;
import com.nk.recipesapi.repositories.IProductRepository;
import com.nk.recipesapi.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<ProductEntity, Integer> implements IProductService {

    private final IProductRepository repository;

    @Override
    protected IGenericRepository<ProductEntity, Integer> getRepo() {
        return repository;
    }
}
