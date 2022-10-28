package com.example.shoppingcart.controller;


import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.CartResponse;
import com.example.shoppingcart.model.Item;
import com.example.shoppingcart.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class CartController {


    @Autowired
    private CartService cartService;
    @PostMapping(path = "/carts", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createItems(@RequestBody Cart cart) {
        CartResponse cartResponse = cartService.createItems(cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }


    @PutMapping(path = "/carts/{name}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCart( @RequestBody Item item, @PathVariable String name)  {
        cartService.updateCart(item,name);
        return ResponseEntity.ok().build();
    }



  /*  @PutMapping(path = "/carts/{id}/{name}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCart(@PathVariable Long id, @RequestBody Cart cart, @PathVariable String name)  {
        cartService.updateCart(id,cart,name);
        return ResponseEntity.ok().build();
    }*/
}
