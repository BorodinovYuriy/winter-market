package ru.gb.spring.wintermarket.dto;

import lombok.Data;
import ru.gb.spring.wintermarket.entity.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart(){
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        //возвратит немодифицируемый лист
        return Collections.unmodifiableList(items);
    }
    public void  add(Product product) { // TODO: 15.12.2022 доработать в дз
        items.add(new CartItem(
                product.getId(),
                product.getTitle(),
                1,
                product.getPrice(),
                product.getPrice())
        );
        recalculate();
    }
    private void recalculate(){
        totalPrice = 0;
        for(CartItem item : items){
            totalPrice += item.getPrice();
        }
    }

}
