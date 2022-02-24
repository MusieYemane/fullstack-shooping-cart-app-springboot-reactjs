package com.mosi.shoppingCart.product.controller;

import com.mosi.shoppingCart.product.exception.ResourceNotFoundException;
import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.domain.Products;
import com.mosi.shoppingCart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Products getAllProducts(){
        return new Products(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product product= productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id:" + id));
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        Product updatedProduct= productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id:" + id));
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductDesc(product.getProductDesc());
        updatedProduct.setProductPrice(product.getProductPrice());
        updatedProduct.setImages(product.getImages());

        productService.addProduct(updatedProduct);

        return ResponseEntity.ok(updatedProduct);

    }



}
