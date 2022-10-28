package com.example.otmShopping.controller;

import com.example.otmShopping.model.Cart;
import com.example.otmShopping.model.CartResponse;
import com.example.otmShopping.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping(value = "/carts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createCart (@RequestBody Cart cart){
        CartResponse cartResponse = cartItemService.createCart(cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/carts/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCartById (@PathVariable Long cartId){
        Cart cart = cartItemService.getCartById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping(value = "/carts/{cartId}")
    public ResponseEntity<Void> deleteCartById (@PathVariable Long cartId){
        cartItemService.deleteCartById(cartId);
        return ResponseEntity.ok().build();
    }

}

