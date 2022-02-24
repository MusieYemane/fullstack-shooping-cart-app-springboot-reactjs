package com.mosi.shoppingCart.product.service.impl;

import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.repository.ProductRepo;
import com.mosi.shoppingCart.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepo.findById(productId);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
