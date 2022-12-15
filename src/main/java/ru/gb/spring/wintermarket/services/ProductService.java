package ru.gb.spring.wintermarket.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.spring.wintermarket.entity.Product;
import ru.gb.spring.wintermarket.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product>findAll() {
        System.out.println(productRepository.findAll()+"test!!!");
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
