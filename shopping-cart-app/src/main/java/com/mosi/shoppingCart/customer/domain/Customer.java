package com.mosi.shoppingCart.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {
    @Id
    private Long id;
    @NotNull @NotBlank
    private String name;
    @NotNull @NotBlank
    private String username;
    @NotNull @NotBlank
    private String password;
    private Cart cart=new Cart();

    public Customer(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
