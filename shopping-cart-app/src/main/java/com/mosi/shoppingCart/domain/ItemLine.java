package com.mosi.shoppingCart.domain;

import com.mosi.shoppingCart.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ItemLine {
    @Id
    private int id;
    private int quantity;
    private Product product;
}
