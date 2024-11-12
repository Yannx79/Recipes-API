package com.nk.recipesapi.controllers;

import com.nk.recipesapi.dto.IngredientDTO;
import com.nk.recipesapi.entities.IngredientEntity;
import com.nk.recipesapi.services.IIngredientService;
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
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IIngredientService service;

    @Qualifier("categoryModelMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> readAll() throws Exception {
        List<IngredientDTO> list = service.readAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDTO> readById(@PathVariable("id") Integer id) throws Exception {
        IngredientDTO dto = convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> create(@Valid @RequestBody IngredientDTO dto) throws Exception {
        IngredientEntity entity = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody IngredientDTO dto) throws Exception {
        dto.setId(id);
        IngredientEntity entity = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private IngredientDTO convertToDTO(IngredientEntity entity) {
        return modelMapper.map(entity, IngredientDTO.class);
    }

    private IngredientEntity convertToEntity(IngredientDTO dto) {
        return modelMapper.map(dto, IngredientEntity.class);
    }


}
