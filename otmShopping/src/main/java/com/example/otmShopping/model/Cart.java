package com.example.otmShopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cart {
    private String firstName;
    private String lastName;
    private List<Item> items;

}
