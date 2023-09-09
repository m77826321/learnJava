package com.example.learn.service;

import com.example.learn.entity.Product;
import com.example.learn.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct() {
        var lst = productRepository.findAll();
        return lst;
    }

    public Product addProduct(Product product) throws Exception {
        if (product.getName().length() > 5) {
            throw new Exception("Sorry Add");
        }
        var productSaved = productRepository.save(product);
        return productSaved;
    }
}
