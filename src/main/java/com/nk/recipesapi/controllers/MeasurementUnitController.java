package com.nk.recipesapi.controllers;

import com.nk.recipesapi.dto.MeasurementUnitDTO;
import com.nk.recipesapi.entities.MeasurementUnitEntity;
import com.nk.recipesapi.services.IMeasurementUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurement-unit")
@RequiredArgsConstructor
public class MeasurementUnitController {

    private final IMeasurementUnitService service;

    @Qualifier("measurementUnitModelMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MeasurementUnitDTO>> readAll() throws Exception {
        List<MeasurementUnitDTO> list = service.readAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementUnitDTO> readById(@PathVariable("id") Integer id) throws Exception {
        MeasurementUnitDTO dto = convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MeasurementUnitDTO> create(@Valid @RequestBody MeasurementUnitDTO dto) throws Exception {
        MeasurementUnitEntity entity = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementUnitDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MeasurementUnitDTO dto) throws Exception {
        dto.setId(id);
        MeasurementUnitEntity entity = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private MeasurementUnitDTO convertToDTO(MeasurementUnitEntity entity) {
        return modelMapper.map(entity, MeasurementUnitDTO.class);
    }

    private MeasurementUnitEntity convertToEntity(MeasurementUnitDTO dto) {
        return modelMapper.map(dto, MeasurementUnitEntity.class);
    }


}
