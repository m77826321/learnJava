package com.example.learn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private int number;
    @NonNull
    private BigDecimal price;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="order_product" ,
            joinColumns={@JoinColumn(name="order_id")},inverseJoinColumns ={@JoinColumn(name="product_id")})
    private Set<Product> products;

    public void addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        products.add((product));
    }
}
