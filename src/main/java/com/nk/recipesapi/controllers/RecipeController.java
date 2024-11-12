package com.nk.recipesapi.controllers;

import com.nk.recipesapi.dto.RecipeDTO;
import com.nk.recipesapi.entities.RecipeEntity;
import com.nk.recipesapi.services.IRecipeService;
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
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final IRecipeService service;

    @Qualifier("recipeModelMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> readAll() throws Exception {
        List<RecipeDTO> list = service.readAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> readById(@PathVariable("id") Integer id) throws Exception {
        RecipeDTO dto = convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> create(@Valid @RequestBody RecipeDTO dto) throws Exception {
        RecipeEntity entity = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody RecipeDTO dto) throws Exception {
        dto.setId(id);
        RecipeEntity entity = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private RecipeDTO convertToDTO(RecipeEntity entity) {
        return modelMapper.map(entity, RecipeDTO.class);
    }

    private RecipeEntity convertToEntity(RecipeDTO dto) {
        return modelMapper.map(dto, RecipeEntity.class);
    }


}
