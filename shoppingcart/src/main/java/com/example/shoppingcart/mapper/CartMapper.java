package com.example.shoppingcart.mapper;

import com.example.shoppingcart.entity.CartEntity;
import com.example.shoppingcart.model.Cart;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartEntity modelToEntity(Cart cartRequest);

    Cart entityToModel(CartEntity cartEntity);

    List<Cart> setEntityTosetModel(List<CartEntity> cartEntities);
}
