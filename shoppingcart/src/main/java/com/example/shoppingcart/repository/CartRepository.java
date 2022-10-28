package com.example.shoppingcart.repository;


import com.example.shoppingcart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
