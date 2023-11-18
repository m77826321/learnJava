package com.example.learn.controller;

import com.example.learn.entity.Product;
import com.example.learn.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Tag(name = "Product", description = "defines endpoints for Product")
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Validated
@Log4j2
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/get"})
    public List<Product> getAllCheckOutStatusBankTransferLimited() {

       return productService.getProducts();
    }


    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product) throws Exception {
        return productService.addProduct(product);
    }

    @InitBinder
    public void initBinder(@NotNull WebDataBinder dataBinder){
        StringTrimmerEditor  stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
}
