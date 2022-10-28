package com.example.oneToOneMapping.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "oto3address")
public class AddressEntity {
    @Id
    private Long id;
    @Column(name = "address_one")
    private String addressOne;
    @Column(name = "address_two")
    private String addressTwo;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private PersonEntity person;

}
