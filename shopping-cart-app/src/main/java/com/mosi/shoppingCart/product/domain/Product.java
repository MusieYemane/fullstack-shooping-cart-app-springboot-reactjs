package com.mosi.shoppingCart.product.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document
public class Product {
    @Id
    private Long productId;
    private String productName;
    private double productPrice;
    private String productDesc;
    private List<String> images;
}
