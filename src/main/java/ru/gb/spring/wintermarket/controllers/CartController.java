package ru.gb.spring.wintermarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.spring.wintermarket.dto.Cart;
import ru.gb.spring.wintermarket.services.CartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cartService.add(id);
    }
    @GetMapping()
    public Cart getCurrentCart(){
        return cartService.getCurrentCart();
    }







}

