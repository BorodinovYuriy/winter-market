package ru.gb.spring.wintermarket.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.wintermarket.entity.Product;
import ru.gb.spring.wintermarket.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAll();
    }


    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id).get();
    }
    @DeleteMapping("/{id}")
    public void DeleteProductById(@PathVariable Long id) {
         productService.deleteProductById(id);
    }
}
