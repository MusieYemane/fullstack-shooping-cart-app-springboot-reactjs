package com.mosi.shoppingCart.customer.domain;

import com.mosi.shoppingCart.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartLine {
    private Product product;
    private int quantity;

    public double getTotalPrice(){
        double unitPrice= product.getProductPrice()*quantity;
        return unitPrice;
    }
}
