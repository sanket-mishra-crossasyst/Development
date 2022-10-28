package com.example.otmShopping.mapper;

import com.example.otmShopping.entity.ItemsEntity;
import com.example.otmShopping.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemsEntity itemToEntity (Item item);
    Item entityToItem (ItemsEntity itemsEntity);
}
