package com.example.learn.service;

import com.example.learn.entity.Product;
import com.example.learn.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        var lst = productRepository.findAll();
        return lst;
    }

    @Cacheable(cacheNames = "product-cache", key = "#id")
    public Product getProduct(Long id) {
        var product = productRepository.findById(id).get();
        return product;
    }

    @Transactional
    @CacheEvict(cacheNames = "product-cache", key = "#product.id")
    public Product addProduct(Product product) throws Exception {
        if (product.getName().length() > 5) {
            throw new Exception("Sorry Add");
        }
        var productSaved = productRepository.save(product);
        return productSaved;
    }
}
