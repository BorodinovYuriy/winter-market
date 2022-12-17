package ru.gb.spring.wintermarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.spring.wintermarket.dto.Cart;
import ru.gb.spring.wintermarket.entity.Product;
import ru.gb.spring.wintermarket.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }
    public Cart getCurrentCart() {
        return tempCart;// TODO: 15.12.2022 дальше метод будет модифицироваться
    }
    public void add(Long productId){
        Product product = productService.
                findById(productId).
                orElseThrow(()-> new ResourceNotFoundException
                        ("Невозможно добавить в корзину," +
                                " id не найден. id: " + productId));
        tempCart.add(product);
    }
}
