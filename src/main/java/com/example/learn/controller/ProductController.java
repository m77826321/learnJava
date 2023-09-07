package com.example.learn.controller;

import com.example.learn.entity.Product;
import com.example.learn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/getProduct"})
    public List<Product> getAllCheckOutStatusBankTransferLimited() {

       return productService.getProduct();
    }


    @PostMapping
    public Product addProduct(@PathVariable Product product){
        return productService.addProduct(product);
    }
}
