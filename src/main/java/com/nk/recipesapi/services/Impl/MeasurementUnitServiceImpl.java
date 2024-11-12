package com.nk.recipesapi.services.Impl;

import com.nk.recipesapi.entities.MeasurementUnitEntity;
import com.nk.recipesapi.repositories.IGenericRepository;
import com.nk.recipesapi.repositories.IMeasurementUnitRepository;
import com.nk.recipesapi.services.IMeasurementUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementUnitServiceImpl extends CRUDImpl<MeasurementUnitEntity, Integer> implements IMeasurementUnitService {

    private final IMeasurementUnitRepository repository;

    @Override
    protected IGenericRepository<MeasurementUnitEntity, Integer> getRepo() {
        return repository;
    }
}
