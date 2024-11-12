package com.nk.recipesapi.controllers;

import com.nk.recipesapi.config.ModelMapperConfig;
import com.nk.recipesapi.dto.CategoryDTO;
import com.nk.recipesapi.entities.CategoryEntity;
import com.nk.recipesapi.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;

    @Qualifier("categoryModelMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> readAll() throws Exception {
        List<CategoryDTO> list = service.readAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id) throws Exception {
        CategoryDTO dto = convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO dto) throws Exception {
        CategoryEntity entity = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CategoryDTO dto) throws Exception {
        dto.setId(id);
        CategoryEntity entity = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CategoryDTO convertToDTO(CategoryEntity entity) {
        return modelMapper.map(entity, CategoryDTO.class);
    }

    private CategoryEntity convertToEntity(CategoryDTO dto) {
        return modelMapper.map(dto, CategoryEntity.class);
    }

}
