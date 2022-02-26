package com.mosi.shoppingCart.customer.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

// value object
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
    private List<CartLine> cartLines= new ArrayList<CartLine>();

    public double getTotalPrice(){
        double totalPrice = 0;
        for (CartLine cl:cartLines) {
            totalPrice+= cl.getTotalPrice();
        }

        return totalPrice;
    }
}
