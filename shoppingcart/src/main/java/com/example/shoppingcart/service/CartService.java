package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.CartEntity;
import com.example.shoppingcart.entity.ItemEntity;
import com.example.shoppingcart.mapper.CartMapper;
import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.CartResponse;
import com.example.shoppingcart.model.Item;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartMapper cartMapper;

    public CartResponse createItems(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        CartEntity cartEntity = cartMapper.modelToEntity(cart);
        cartRepository.save(cartEntity);
        log.info("Item has been added successfully in your cart");
        cartResponse.setId(cartEntity.getCartId());
        return cartResponse;
    }

    public void updateCart(Item item, String name) {
        ItemEntity itemEntity = itemRepository.findByName(name);
        if (itemEntity.getName().equalsIgnoreCase(name)){
        itemEntity.setQuantity(item.getQuantity());
        itemEntity.setPrice(item.getPrice());
        itemRepository.save(itemEntity);
        }
    }

}
