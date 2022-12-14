package ru.gb.spring.wintermarket.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private String price;

}
