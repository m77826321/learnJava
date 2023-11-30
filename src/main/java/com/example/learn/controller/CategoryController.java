package com.example.learn.controller;

import com.example.learn.entity.Product;
import com.example.learn.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Category", description = "defines endpoints for Category")
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Validated
@Log4j2
public class CategoryController {

    private ProductService productService;

    @Autowired
    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/get"})
    public List<Product> getAllCheckOutStatusBankTransferLimited() {

       return productService.getProducts();
    }


    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) throws Exception {
        return productService.addProduct(product);
    }
}
