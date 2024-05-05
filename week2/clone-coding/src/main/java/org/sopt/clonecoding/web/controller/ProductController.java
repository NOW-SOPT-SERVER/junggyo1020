package org.sopt.clonecoding.web.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.clonecoding.service.ProductService;
import org.sopt.clonecoding.web.dto.ProductCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductCreateDto productCreateDto){
        return ResponseEntity.created(URI.create(productService.createProduct(productCreateDto))).build();
    }
}
