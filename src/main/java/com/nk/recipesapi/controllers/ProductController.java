package com.nk.recipesapi.controllers;

import com.nk.recipesapi.dto.ProductDTO;
import com.nk.recipesapi.entities.ProductEntity;
import com.nk.recipesapi.services.IProductService;
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
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;

    @Qualifier("productModelMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> readAll() throws Exception {
        List<ProductDTO> list = service.readAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> readById(@PathVariable("id") Integer id) throws Exception {
        ProductDTO dto = convertToDTO(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) throws Exception {
        ProductEntity entity = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ProductDTO dto) throws Exception {
        dto.setId(id);
        ProductEntity entity = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ProductDTO convertToDTO(ProductEntity entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }

    private ProductEntity convertToEntity(ProductDTO dto) {
        return modelMapper.map(dto, ProductEntity.class);
    }

}
