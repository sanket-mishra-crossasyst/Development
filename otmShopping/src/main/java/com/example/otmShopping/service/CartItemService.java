package com.example.otmShopping.service;

import com.example.otmShopping.entity.CartEntity;
import com.example.otmShopping.mapper.CartMapper;
import com.example.otmShopping.model.Cart;
import com.example.otmShopping.model.CartResponse;
import com.example.otmShopping.repository.CartRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CartItemService {
@Autowired
private CartMapper cartMapper;
@Autowired
private CartRepository cartRepository;
    public CartResponse createCart(Cart cart) {
        CartEntity cartEntity = null;
        cartEntity = cartMapper.cartToEntity(cart);
        cartRepository.save(cartEntity);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        return cartResponse;
    }

    public Cart getCartById(Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
       Cart cart = new Cart();
        if (cartEntity.isPresent()) {
            cart = cartMapper.entityToCart(cartEntity.get());
            log.info("Id Found {}", cartId);
        } else {
            log.info("Id Not Found");
        }
        return cart;
    }

    public void deleteCartById(Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        if(cartEntity.isPresent()){
            cartRepository.deleteById(cartId);
            log.info("id {} deleted", cartId);
        }
        else{
            log.info("Id not Found {}", cartId);
        }
    }
}
