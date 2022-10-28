package com.example.shoppingcart.mapper;

import com.example.shoppingcart.entity.ItemEntity;
import com.example.shoppingcart.model.Item;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity modelToEntity(Item item);

    Item entityToModel(ItemEntity itemEntity);
    List<Item> entitySetToModelSet(List<ItemEntity> itemEntityList);
}
