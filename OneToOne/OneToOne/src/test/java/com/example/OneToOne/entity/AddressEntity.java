package com.example.OneToOne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class AddressEntity {
    @Id
    private Long addressId;
    @Column
    private String address1;
    private String address2;
    private String city;
    private  String state;
    private String zipCode;
}
