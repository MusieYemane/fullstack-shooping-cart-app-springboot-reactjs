package com.mosi.shoppingCart.customer.controller;


import com.mosi.shoppingCart.customer.repository.CustomerRepo;
import com.mosi.shoppingCart.customer.domain.Cart;
import com.mosi.shoppingCart.customer.domain.CartLine;
import com.mosi.shoppingCart.customer.domain.Customer;
import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductService productService;


    @PostMapping("/register")
    public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer){
        Optional<Customer> user= customerRepo.findByUsernameAndAndPassword(customer.getUsername(), customer.getPassword());
        if(user.isPresent()) return ResponseEntity.notFound().build();  //404 not found
        return ResponseEntity.ok(customerRepo.save(customer));  //200 ok
    }


    @GetMapping("login")  // /?username=musie&password=mosi@1996
    public ResponseEntity<Customer> login(@RequestParam("username") String username, @RequestParam("password") String passsword){
        Optional<Customer> user= customerRepo.findByUsernameAndAndPassword(username,passsword);
        if(user.isPresent()) return ResponseEntity.ok(user.get());
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{userId}/cart")
    public ResponseEntity<Cart> getCustomerCart(@PathVariable("userId") Long userId){
        Customer customer=customerRepo.findById(userId).get();
        return ResponseEntity.ok(customer.getCart());
    }
    // add product to cart
    @GetMapping("/{userId}/cart/{productId}/{quantity}")
    public ResponseEntity<Customer> addProductToCart(@PathVariable("userId") Long userId,
                                                 @PathVariable("productId") Long productId,
                                                 @PathVariable("quantity") int quantity){
        Customer customer= customerRepo.findById(userId).get();
        Cart cart= customer.getCart();

        //check if product already available in cart, if yes, then just the quantity
        for (CartLine cartLine : cart.getCartLines()){
            Product prod= cartLine.getProduct();
            if(prod.getProductId()==productId) {
                cartLine.setQuantity(cartLine.getQuantity()+quantity);
                return ResponseEntity.ok(customerRepo.save(customer));

            }
        }

        //else get the product and add it to cart
        Product product= productService.getProductById(productId).get();
        CartLine cl= new CartLine(product, quantity);
        cart.getCartLines().add(cl);
        return ResponseEntity.ok(customerRepo.save(customer));
    }

    //to dos
    //remove product from cart

    

    //place an order
}
