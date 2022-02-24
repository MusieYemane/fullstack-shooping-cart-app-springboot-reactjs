package com.mosi.shoppingCart.product.repository;


import com.mosi.shoppingCart.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product, Long> {
    Product findByProductName(String productName);
}
