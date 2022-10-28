package com.example.otmShopping.repository;

import com.example.otmShopping.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemsEntity, Long> {
}
