package com.mosi.shoppingCart.product.service;

import com.mosi.shoppingCart.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long productId);
    Product addProduct(Product product);
    Product updateProduct(Long productId, Product product);
    void deleteProduct(Long productId);

}
