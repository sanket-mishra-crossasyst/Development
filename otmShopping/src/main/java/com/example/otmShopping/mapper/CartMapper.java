package com.example.otmShopping.mapper;

import com.example.otmShopping.entity.CartEntity;
import com.example.otmShopping.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartEntity cartToEntity (Cart cart);
    Cart entityToCart(CartEntity cartEntity);
}
